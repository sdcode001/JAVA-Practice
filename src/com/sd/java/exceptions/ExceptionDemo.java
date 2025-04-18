package com.sd.java.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo {

	public static void main(String[] args) {
		System.out.println("main start...");
		share();
		System.out.println("main end...");
	}
	
	public static void share() {
		System.out.println("share start...");
		try {
			String response = HttpConnect.send(0, "Hello", "https://goodships.com");
			System.out.println("after invoking send...");
			int responseCode = APIParser.parseSendResponseCode(response, "Hello", "https://goodships.com");
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("Connection to a different server...");
		}
		catch(APIFormatChangeException e) {
			e.printStackTrace();
			//print lower level exception
			//e.getCause().printStackTrace()
			System.out.println("e.getElementName(): "+e.getElementName());
			System.out.println("e.getResponse(): "+e.getResponse());
		}
		catch(Throwable e) {
			//for any exception or error
			throw e;
		}
		finally {
			System.out.println("Inside share finally...");
		}
		
		System.out.println("share end...");
	}

}
