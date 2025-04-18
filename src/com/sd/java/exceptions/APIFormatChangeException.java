package com.sd.java.exceptions;

public class APIFormatChangeException extends Exception {
	private String response;
	private String elementName;
	private String partner;
	
	public APIFormatChangeException(String message) {
		super(message);
	}
	
	public APIFormatChangeException(String message, String response, String elementName, String partner, Throwable e) {
		super(message, e);
		this.elementName = elementName;
		this.partner = partner;
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public String getElementName() {
		return elementName;
	}

	public String getPartner() {
		return partner;
	}

}
