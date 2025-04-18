package com.sd.java.oop.abstractDemo;

public abstract class AbstractSubClass extends AbstractSuperClass{
	
     protected AbstractSubClass(int inc1, int inc2) {
		super(inc1, inc2);
	}

	public int foo() {
    	 System.out.println("AbstractSubClass: foo()");
    	 return 10;
     }
}
