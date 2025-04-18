package com.sd.java.basics;

import java.util.HashMap;


public class InitializerBlockDemo {
	
	static HashMap<String, Integer> map = new HashMap();
	int passKey, id = 0;
	
	static {
		map.put("Souvik", 2);
		map.put("Sourav", 4);
		System.out.println("Inside static initializer block");
	}
	
	{
		if(this.id==0) {this.passKey = 100;}
		else {this.passKey = 1000;}
		System.out.println("Inside instance initializer block");
	}
	
	InitializerBlockDemo() {
		System.out.println("Inside InitializerBlockDemo()");
	}
	
    InitializerBlockDemo(int id) {
		this.id = id;
		System.out.println("Inside InitializerBlockDemo(int id)");
	}

	public static void main(String[] args) {
		InitializerBlockDemo obj = new InitializerBlockDemo(5);

	}

}
;
