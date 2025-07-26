package com.sd.java.concurrency;

public class ThreadDemo {

	public static void main(String[] args) {
		Runnable task = new MyTask();
        
		Thread thread = new Thread(task);
		
		thread.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("Inside main()...");
	}

}
