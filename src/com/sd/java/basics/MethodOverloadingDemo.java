package com.sd.java.basics;

public class MethodOverloadingDemo {
	
	void update(String name, int age) {
		System.out.println("Inside update(String name, int age)");
	}
	
    void update(int age, String name) {
    	System.out.println("Inside update(int age, String name)");
	}
    
    void update(int age, String name, int id){
    	System.out.println("Inside update(int age, String name, int id)");
    }
    
    void update(short n) {
    	System.out.println("Inside update(short n)");
    }
    
    void update(int n) {
    	System.out.println("Inside update(int n)");
    }

	public static void main(String[] args) {
		MethodOverloadingDemo obj = new MethodOverloadingDemo();
		obj.update(1000);
		byte n = 50;
		obj.update(n);
	}

}
