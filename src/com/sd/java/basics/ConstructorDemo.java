package com.sd.java.basics;

public class ConstructorDemo {
	
	int a, b, c;
	
	static int d = 10;
	
	//default constructor
	ConstructorDemo(){}
	
	//constructor delegation
	ConstructorDemo(int a, int b, int c){
		this(b, c);
		this.a = a;
	}
	
	ConstructorDemo(int b, int c){
		this(c);
		this.b = b;
	}
	
	ConstructorDemo(int c){
		this.c = c;
	}
	
	public void compute() {
		System.out.println("a = "+this.a+", b = "+this.b+", c = "+this.c);
	}
    
	public static void main(String[] args) {
		ConstructorDemo obj = new ConstructorDemo(3, 6, 9);
		obj.compute();
	}

}
