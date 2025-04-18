package com.sd.java.io;
        
import java.util.Scanner;
        
public class ScannerDemo {
        
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter value: ");
        int a = scan.nextInt();
        System.out.println(a);
        System.out.print("Enter value: ");
        String s = scan.next();
        System.out.println(s);
        
	}   
        
}       
