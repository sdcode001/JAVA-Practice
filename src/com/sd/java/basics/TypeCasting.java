package com.sd.java.basics;

public class TypeCasting {

	public static void compute() {
		//Implicit casting
		int i = 343434;
		long l = i + 223233;
		System.out.println("l = " + l);
		float f = i + 54;
		System.out.println("f = " + f);
		char c = 'R';
	    int ic = c;
		System.out.println("ic = " + ic);
		
		//Explicit casting
		long l1 = 3445545455455454L;
		int i1 = (int)l1; //out of range- data loss
		System.out.println("i1 = " + i1);
		double d = 445454.546565;
		int i2 = (int)d; //truncate
		System.out.println("i2 = " + i2);
		char c1 = 'A';
		byte b = (byte)c1;
		System.out.println("b = " + b);
	}
	
	public static void main(String[] args) {
       compute();
	}

}
