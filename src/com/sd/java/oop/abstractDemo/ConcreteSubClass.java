package com.sd.java.oop.abstractDemo;

public class ConcreteSubClass extends AbstractSubClass{
	
	protected ConcreteSubClass(int inc1, int inc2) {
		super(inc1, inc2);
	}

	public int bar() {
   	 System.out.println("ConcreteSubClass: bar()");
   	 return 20;
    }

	public static void main(String[] args) {
		ConcreteSubClass obj = new ConcreteSubClass(1, 2);
		obj.compute();
	}

}
