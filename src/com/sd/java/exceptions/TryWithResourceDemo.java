package com.sd.java.exceptions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class TryWithResourceDemo {

	public static void main(String[] args) {
		System.out.println("main start...");
		try {
			copyAndSaveWithARM();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("main end...");
	}
	
	public static void copyAndSaveWithARM() throws IOException {
		System.out.println("copyAndSaveWithARM start...");
		
		String inputImgPath = "D:\\JAVA_Workshop\\project1\\src\\com\\sd\\java\\exceptions\\image.jpeg";
		String outputImgPath = "D:\\JAVA_Workshop\\project1\\src\\com\\sd\\java\\exceptions\\output-image.jpeg";
		
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputImgPath)); 
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputImgPath))){
			
			byte[] buffRead = new byte[5000];
			int numBuffRead;
			while((numBuffRead = in.read(buffRead)) != -1) {
				out.write(buffRead, 0, numBuffRead);
			}
		}
		catch(IOException e) {
			throw e;
		}
		System.out.println("copyAndSaveWithARM end...");
	}

}
