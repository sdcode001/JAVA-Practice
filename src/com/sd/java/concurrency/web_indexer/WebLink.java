package com.sd.java.concurrency.web_indexer;

public class WebLink {
	private int id;
	private String url;
	//ensure memory visibility over Threads
	private volatile String htmlContent = null;
	
    public WebLink(int id, String url) {
    	this.id=id; 
    	this.url=url;
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
