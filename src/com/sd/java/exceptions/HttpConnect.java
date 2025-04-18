package com.sd.java.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpConnect {
	/*
	 * @throw IllegalArgumentException when destination<0 || destination>1
	 */
	
	public static String send(int destination, String data, String partner) throws IOException, FileNotFoundException {
		System.out.println("send start...");
		String response = "success";
		
		if(destination<0 || destination>1) {
			//unchecked exception
			throw new IllegalArgumentException();
		}
		else if(destination == 1) {
			throw new FileNotFoundException();
		}
		else if(destination == 0) {
			//throw new IOException();
			response = "<result><code>success</code></result>";
		}
		System.out.println("send end...");
		return response;
	}

}