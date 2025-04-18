package com.sd.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class CharacterStreamDemo {
	private static String inputFilePath = "D:\\JAVA_Workshop\\project1\\src\\com\\sd\\java\\io\\data.txt";
	private static String outputFilePath = "D:\\JAVA_Workshop\\project1\\src\\com\\sd\\java\\io\\output-data.txt";
	
	private static void readWriteWithBuffering(){
		File file = new File(inputFilePath);
		System.out.println("File size is: "+file.length()+" bytes");
		
		StringBuilder text = new StringBuilder();
		long startTime, elaspedTime;
		
		try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), "UTF-8"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8"))){
			
			startTime = System.currentTimeMillis();
			String lineText;
			
			while((lineText = in.readLine()) != null) {
				text.append(lineText).append("\n");
			}
			
			out.write(text.toString());
			
			elaspedTime = System.currentTimeMillis() - startTime;
			System.out.println("Elasped time is: "+elaspedTime+" msec");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readWriteWithBuffering();
	}

}
