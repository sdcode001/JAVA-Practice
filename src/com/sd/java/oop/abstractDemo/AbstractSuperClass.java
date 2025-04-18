package com.sd.java.oop.abstractDemo;

public abstract class AbstractSuperClass {
	private int inc1;
	private int inc2;
	
	protected AbstractSuperClass(int inc1, int inc2) {
		this.inc1 = inc1;
		this.inc2 = inc2;
	}
	
	public abstract int foo();
	
	public abstract int bar();
	
	public void compute() {
		int f = this.foo();
		int b = this.bar();
		f = f+this.inc1;
		b = b+this.inc2;
		int total = f + b;
		System.out.println("AbstractSuperClass: compute() => total=" + total);
	}

}
