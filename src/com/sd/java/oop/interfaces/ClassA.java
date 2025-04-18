package com.sd.java.oop.interfaces;

public class ClassA extends AbstractA implements A, B {

	public void bar() {
		System.out.println("ClassA: foo()");
	}

	public void fooB() {
		System.out.println("ClassA: fooB()");
	}
	
	public static void main(String[] args) {
		A obj1 = new ClassA();
		AbstractA obj2 = new ClassA();
		B obj3 = new ClassA();
		
		//int i = id; //ambiguous
		
		int i = B.id;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		
	}

}
