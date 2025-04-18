package com.sd.java.oop.p0;

public class ConstructorChainingDemo extends Editor{
	
	public ConstructorChainingDemo(int id){
		super(id);
		System.out.println("ConstructorChainingDemo constructor");
	}

	public static void main(String[] args) {
		ConstructorChainingDemo obj = new ConstructorChainingDemo(9);
		
	}

}
