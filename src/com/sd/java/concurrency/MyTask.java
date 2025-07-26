package com.sd.java.concurrency;

public class MyTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside run()...");
		foo();
	}
	
	public void foo() {
		System.out.println("Inside foo()...");
		bar();
	}
	
	public void bar() {
		System.out.println("Inside bar()...");
	}

}
