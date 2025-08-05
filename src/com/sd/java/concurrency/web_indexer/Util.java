package com.sd.java.concurrency.web_indexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class Util {

	public static String downloadWebpageContent(String sourceUrl) throws URISyntaxException, IOException {
		String data = null;
		
		  try {
			  URL url = new URI(sourceUrl).toURL();
			  HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			  int statusCode = conn.getResponseCode();
			  if(statusCode >= 200 && statusCode < 300) {
				  data = readStream(conn.getInputStream());
			  }
		  }
		  catch (URISyntaxException e) {
			 throw e;
		  }
		  catch(IOException ex) {
			 throw ex;
		  }
		  
		return data;
	}
	
	
	private static String readStream(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		try(BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))){
			String line;
			while((line = in.readLine()) != null) {
				sb.append(line).append("\n");
			}
			
		} catch (IOException e) {
			throw e;
		}
		return sb.toString();
	}
}
