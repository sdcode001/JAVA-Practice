package com.sd.java.basics;

public class MethodDemo {
	
	static int additionalCharge = 1000;
	
	public static int sum(int x, int y) {
		return x+y;
	}
	
	public int getTotalCharge(int a, int b) {
		return sum(a, b) + additionalCharge;
	}
	
	public double avg(int x, int y) {
		int s = sum(x, y);
		return (double)s/2;
	}
	
	public void fun(int id) {
		id=1001;
	}
	
	public void fun(Student s) {
		//s = new Student();
		s.id = 1001;
	}

	public static void main(String[] args) {
         MethodDemo obj = new MethodDemo();
         System.out.println("avg = " + obj.avg(4, 5));
         
         int id=1000;
         obj.fun(id);
         System.out.println("id = " + id);
         
         Student s = new Student();
         s.id = 1000;
         obj.fun(s);
         System.out.println("s.id = " + s.id);
	}

}
