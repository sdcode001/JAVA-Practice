package com.sd.java.concurrency.web_indexer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
*Problem Statement- 
*    Stop the Downloader & Indexer threads if its taking more than 1 second to complete using Interruption.
*    
*Solution:
*    Here we using Explicit Locks with Interruption and indirect thread closer mechanism for Downloader thread.
*    
*Indirect-Thread-Closer-Mechanism:
*    Since the downloader thread is blocked on a blocking I/O read, it cannot be interrupted using Thread.interrupt().
*    To handle this, the downloader thread spawns a helper thread whose responsibility is to close the underlying 
*    I/O stream. This forces the downloader thread to throw an IOException and unblock. The helper thread performs 
*    this action upon receiving a signal from the indexer thread, which itself is interrupted by the main thread 
*    after a timeout.
*    
*    Indexer interrupted -> sets weblink.stop = true -> helper thread sees this -> closes stream -> Downloader gets IOException
**/

public class TimedDownloaderIndexer {
    private static Deque<WebLink> queue = new ArrayDeque<WebLink>();
    private static List<Thread> downloaderThreadList = new ArrayList<Thread>();
    private static List<Thread> indexerThreadList = new ArrayList<Thread>();
    
	public static void add(WebLink weblink) {
		queue.add(weblink);
	}
	
	public static void go() {
		while(!queue.isEmpty()) {
			WebLink weblink = queue.poll();
			
			ReentrantLock lock = new ReentrantLock();
			Condition pageCondition = lock.newCondition();
			
			Thread dowloader = new Thread(new Downloader(weblink, lock, pageCondition));
			Thread indexer = new Thread(new Indexer(weblink, lock, pageCondition));
			dowloader.setName("DOWNLOADER-THREAD-"+weblink.getId());
			indexer.setName("INDEXER-THREAD-"+weblink.getId());
			
			downloaderThreadList.add(dowloader);
			indexerThreadList.add(indexer);
			
			dowloader.start();
			indexer.start();
		}
		
		//Wait for timeout period(1 second) and interrupt threads which are still alive.
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nTime Up!!\n");
		for(int i=0;i<downloaderThreadList.size();i++) {
			if(downloaderThreadList.get(i).isAlive()) {
				System.out.println(downloaderThreadList.get(i).getName() + " is still active. Stopping it ...");
				//Interrupt the corresponding Indexer thread of Downloader thread.
				indexerThreadList.get(i).interrupt();
			}
		}
		
	}
	
	
	private static class Indexer implements Runnable {
	    private WebLink weblink;
	    private ReentrantLock lock;
	    private Condition lockCondition;
	    private boolean wasInWaitingSate = false;
	    
	    public Indexer(WebLink weblink, ReentrantLock lock, Condition lockCondition) {
	    	this.weblink = weblink;
	    	this.lock=lock;
	    	this.lockCondition=lockCondition;
	    }
	    
		@Override
		public void run() {
				try {
					lock.lockInterruptibly();
					
					String htmlPage = this.weblink.getHtmlContent();
					while(htmlPage==null) {
						System.out.println(this.weblink.getId() + " not yet downloaded. Waiting ...");
						this.lockCondition.await();
						System.out.println(weblink.getId() + " awakened!");
						htmlPage = this.weblink.getHtmlContent();	
					}
				    index(htmlPage);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " interrupted!!");
					//Clean-up: Stopping downloader thread indirectly
					this.weblink.setStop(true);
					
					//marking this thread was in waiting state
					this.wasInWaitingSate = true;
				}
				finally {
					/**
					 * If this thread in waiting state(lock released) and interrupted then unlock() will
					 * throw IllegalMonitorStateException as lock is unavailable. Hence handling this case
					 * with wasInWaitingSate boolean flag.
					 */
					if(!this.wasInWaitingSate) {
						this.lock.unlock();
					}
				}
		}
		
		private void index(String text) {
			if (text != null) {
				System.out.println("\nIndexed: " + weblink.getId() + "\n");
			}
		}
	}


	private static class Downloader implements Runnable {
	    private WebLink weblink;
	    private ReentrantLock lock;
	    private Condition lockCondition;
	    
	    public Downloader(WebLink weblink, ReentrantLock lock, Condition lockCondition) {
	    	this.weblink = weblink;
	    	this.lock=lock;
	    	this.lockCondition=lockCondition;
	    }
		
		@Override
		public void run() {
			if(this.weblink.getUrl()!=null) {
				this.lock.lock();
				try{
					InputStream in = Util.getInputStream(weblink.getUrl());
					
					//Spawn helper thread to kill InputStream after on signal after timeout.
					Thread helperThread = new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								while(!weblink.getStop()) {
								    Thread.currentThread().sleep(1000);
								}
								System.out.println("Time out. Closing stream for " + weblink.getId());
								in.close();
							} catch (InterruptedException e) {
								System.out.println("helperThread interrupted -- " + weblink.getId());
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					});
					
					helperThread.start();
					
					try {
						String htmlContent = Util.readStream(in);
						System.out.println("Download completed for -- "+this.weblink.getId());
						this.weblink.setHtmlContent(htmlContent);
						//Interrupt the helperThread
						helperThread.interrupt();
						this.lockCondition.signalAll();	
					}
					catch(IOException ex) {
						System.out.println(this.weblink.getId() + " could not be downloaded. Terminating "+Thread.currentThread().getName());
					}
				}
				finally {
					this.lock.unlock();
				}
			}
		}
		
	}
	
}
