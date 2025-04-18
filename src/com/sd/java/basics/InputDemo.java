package com.sd.java.basics;

import java.util.Scanner;

public class InputDemo {

	public static void main(String[] args) {
	   Scanner scanner = new Scanner(System.in);
	   
	   System.out.println("Enter value ->");
	   int a = scanner.nextInt();
	   System.out.println("a = " + a);
	   
	   System.out.println("Enter value ->");
       String s = scanner.next();
       System.out.println("s = " + s);
       
       
	}

}
