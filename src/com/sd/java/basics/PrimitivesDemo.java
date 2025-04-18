package com.sd.java.basics;

import java.math.BigDecimal;

class PrimitivesDemo {
	
	int a=90;
	
    static void print() {
        System.out.println("\n\nInside print ...");
        System.out.println("Hello, world!!"); // Advance cursor to beginning of next line
        System.out.println();                 // Print empty line
        System.out.print("Hello, world!!");   // Cursor stayed after the printed string
        System.out.println("Hello,");
        System.out.print(" ");                // Print a space
        System.out.print("world!!");
    }
	  
	  static void primitives() {
		  //Number
		  byte b = 127;
		  short s = 1000;
		  int i = 85566656;
		  int i1 = 334_343_434; // Java 7 --- readability
		  System.out.println("i1 = " + i1);
		  long l = 122233_238778L;
		  System.out.println("l = " + l);
		  long l1 = 443453457;
		  long l2 = 0x0041; //hexadecimal representation
		  System.out.println("l2 = " + l2);
		  int i2 = 0b1000001; //binary representation
		  System.out.println("i2 = " + i2);
		  int max = Integer.MAX_VALUE;
		  System.out.println("int_max = " + max);
		  
		  
		  //Floating points
		  float f = 3434.46566f;
		  System.out.println("f = "+f);
		  float f1 = 967.9456743773447346734637463232323657f; //will be round up
		  System.out.println("f1 = "+f1);
		  float f2 = 23e4f; //23 * 10^4;
		  System.out.println("f2 = "+f2);
		  double d = 76343.35454545;
		  System.out.println("d = "+d);
		  double d1 = 76343.35454545575656565565655655656565656565655565565; //will be round up
		  System.out.println("d1 = "+d1);
		  float min = Float.MIN_VALUE;
		  System.out.println("float_min = " + min);
		  //pitfall of floating point numbers;
		  double d2 = 0.1 + 0.2;
		  System.out.println("d2 = "+d2);
		  double d3 = 1 - 0.9;
		  System.out.println("d3 = "+d3);
		  //use BigDecimal class to solve this pitfall
		  BigDecimal d4 = new BigDecimal("1");
		  BigDecimal d5 = new BigDecimal("0.9");
		  BigDecimal d6 = d4.subtract(d5);
		  System.out.println("d6 = "+ d6); //0.9
		  
		  
		  //Character 
		  char c = 'B';
		  System.out.println("c = "+ c);
		  char c1 = '\u0042';
		  System.out.println("c1 = "+ c1);
		  char c2 = 66;
		  System.out.println("c2 = "+ c2);
		  
		  
		  //Boolean
		  boolean bl = true;
		  System.out.println("bl = "+ bl);
	  }
	  
	  public static void main(String[] args) {		  
		  primitives();
	  }       
}