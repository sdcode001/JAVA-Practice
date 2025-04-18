package com.sd.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
	private static String inputFilePath = "D:\\JAVA_Workshop\\project1\\src\\com\\sd\\java\\io\\image.jpeg";
	private static String outputFilePath = "D:\\JAVA_Workshop\\project1\\src\\com\\sd\\java\\io\\output-image.jpeg";
	
	private static void readWriteWithoutBuffering() {
		File file = new File(inputFilePath);
		System.out.println("File size is: "+file.length()+" bytes");
		
		long startTime, elaspedTime;
		
		try(FileInputStream in = new FileInputStream(inputFilePath);
			FileOutputStream out = new FileOutputStream(outputFilePath)){
			
			startTime = System.currentTimeMillis();
			int readData;
			
			while((readData = in.read()) != -1) {
				out.write(readData);
			}
			
			elaspedTime = System.currentTimeMillis() - startTime;
			System.out.println("Elasped time is: "+elaspedTime+" msec");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
    private static void readWriteWithBuffering() {
    	File file = new File(inputFilePath);
		System.out.println("File size is: "+file.length()+" bytes");
		
		long startTime, elaspedTime;
		
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFilePath));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFilePath))){
			
			startTime = System.currentTimeMillis();
			int numBytesRead;
			byte[] readBytes = new byte[5000];
			
			while((numBytesRead = in.read(readBytes)) != -1) {
				out.write(readBytes, 0, numBytesRead);
			}
			
			elaspedTime = System.currentTimeMillis() - startTime;
			System.out.println("Elasped time is: "+elaspedTime+" msec");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

    
	public static void main(String[] args) {
		//readWriteWithoutBuffering();
		readWriteWithBuffering();

	}

}
