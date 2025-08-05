package com.sd.java.concurrency.web_indexer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * For N web links, this approach creates 2 * N threads.
 * 
 * Note: htmlPage is declared volatile in Weblink
 * 
 * Limitation:
 *    CPU cycles are wasted in Indexer as it is waiting for page to be downloaded
 *
 */

public class NaiveIndexer {
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
	
	
	private static class Downloader implements Runnable {
	    private WebLink weblink;
	    
	    public Downloader(WebLink weblink) {
	    	this.weblink = weblink;
	    }
		
		@Override
		public void run() {
			if(this.weblink.getUrl()!=null) {
				try {
					String content = Util.downloadWebpageContent(this.weblink.getUrl());
					this.weblink.setHtmlContent(content);
				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	
	private static class Indexer implements Runnable {
	    private WebLink weblink;
	    
	    public Indexer(WebLink weblink) {
	    	this.weblink = weblink;
	    }
	    
		@Override
		public void run() {
			while(true) {
				String htmlPage = this.weblink.getHtmlContent();
				if (htmlPage != null) {
					index(htmlPage);
					break;
				} else {
					System.out.println(weblink.getId() + " not yet downloaded!");
				}
			}
		}
		
		private void index(String text) {
			if (text != null) {
				System.out.println("\nIndexed: " + weblink.getId() + "\n");
			}
		}
	}
	
}






