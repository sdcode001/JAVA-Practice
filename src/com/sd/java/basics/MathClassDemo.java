package com.sd.java.basics;

public class MathClassDemo {
	//Making this class non-instantiable
	private MathClassDemo() { }
	
	public static void compute() {
		double rand = Math.random(); //[0.0, 0.9)
		System.out.println("rand*100 = " + rand*100);
		long round = Math.round(34.23);
		System.out.println("round = " + round);
		double ceil = Math.ceil(34.23);
		System.out.println("ceil = " + ceil);
		double floor = Math.floor(34.23);
		System.out.println("floor = " + floor);
		double max = Math.max(34.23, 35);
		System.out.println("max = " + max);
		double pow = Math.pow(3, 5);
		System.out.println("pow = " + pow);
		double sqrt = Math.sqrt(45);
		System.out.println("sqrt = " + sqrt);
		double nan = 0.0/0.0; //NaN
		System.out.println("nan = " + nan);
		double log = Math.log(45); //base 10
		System.out.println("log = " + log);
	}

	public static void main(String[] args) {
	   MathClassDemo.compute();

	}

}
