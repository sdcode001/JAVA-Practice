package com.sd.java.concurrency.web_indexer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * For N web links, this approach creates 2 * N threads.
 * 
 * Benefit: Better coordination of control flow between threads. Relinquishes lock on wait()!
 *          Reduce wastage of CPU cycle
 * 
 * Note: htmlPage is NOT declared volatile in Weblink as unlock on a monitor 
 *          'happens before' every subsequent lock on that same monitor.
 * 
 * Limitation:
 *    Solves task cooperation in a low-level fashion. Josh Bloch says it is like
 *          programming in "concurrency assembly language"
 *    Synchronized blocks are needed
 *
 */

public class WaitNotifyIndexer {
    private static Deque<WebLink> queue = new ArrayDeque<WebLink>();
    
	public static void add(WebLink weblink) {
		queue.add(weblink);
	}
	
	public static void go() {
		while(!queue.isEmpty()) {
			WebLink weblink = queue.poll();
			
			Thread dowloader = new Thread(new Downloader(weblink));
			Thread indexer = new Thread(new Indexer(weblink));
			
			dowloader.start();
			indexer.start();
		}
	}
	
	
	private static class Indexer implements Runnable {
	    private WebLink weblink;
	    
	    public Indexer(WebLink weblink) {
	    	this.weblink = weblink;
	    }
	    
		@Override
		public void run() {
			// Without synchronized block, wait/notify calls will throw IllegalMonitorStateException 
			synchronized(this.weblink) {
				String htmlPage = this.weblink.getHtmlContent();
				// Standard idiom for using wait method
				//    + while condition is critical as some other thread could have acquired the 
				//    lock and changed the state of the variable or 
				//    + Due to "spurious wakeup": A waiting thread can rarely wake up in the   absence of notify.
				while(htmlPage==null) {
					try {
						System.out.println(this.weblink.getId() + " not yet downloaded!");
						this.weblink.wait(); // Suspends thread. Releases lock (unlike sleep()/yield()). Goes into WAITING state
						System.out.println(weblink.getId() + " awakened!");
						htmlPage = this.weblink.getHtmlContent();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
				
				index(htmlPage);
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
	    
	    public Downloader(WebLink weblink) {
	    	this.weblink = weblink;
	    }
		
		@Override
		public void run() {
			if(this.weblink.getUrl()!=null) {
				try {
					synchronized(this.weblink) {
						String content = Util.downloadWebpageContent(this.weblink.getUrl());
						this.weblink.setHtmlContent(content);
						//notify() wakes up single thread (chosen arbitrarily if multiple threads are waiting). Moves waiting threads to BLOCKED
						//Recommended- use notifyAll() instead of notify()
						this.weblink.notifyAll();
					}
					//*** lock released via wait() or exiting synchronized block ***
				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	

}

