package com.sd.java.concurrency.web_indexer;

public class WebLink {
	private int id;
	private String url;
	//ensure memory visibility over Threads
	private volatile String htmlContent = null;
	private volatile boolean stop=false;
	
    public WebLink(int id, String url) {
    	this.id=id; 
    	this.url=url;
    }

    public void setStop(boolean stop) {
    	this.stop=stop;
    }
    
    public boolean getStop() {
    	return this.stop;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
    
    
}
