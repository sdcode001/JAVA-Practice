package com.sd.java.basics;

public class OperatorDemo {
	
	public static void compute() {
		int x = 5;
		x++;
		System.out.println("x++ = "+x);
		x = 5;
		++x;
		System.out.println("++x = "+x);
		x=5;
		int y = x++;
		System.out.println("y = "+y);
		x=5;
		y = ++x;
		System.out.println("y = "+y);
		
		int a = 5+9-3+2*5;
		System.out.println("a = "+a);
		int c = 'a' + 'b';
		System.out.println("c = "+c);
		double d = 9/5*20.1;
		System.out.println("d = "+d);
		
		//comparison operators
	}

	public static void main(String[] args) {
       compute();
	}

}
