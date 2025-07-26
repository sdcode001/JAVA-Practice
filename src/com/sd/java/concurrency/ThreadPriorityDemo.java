package com.sd.java.concurrency;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        
        Thread t1 = new Thread(new EmailCampaign());
        Thread t2 = new Thread(new DataAggregator());
        
        t1.setName("EmailCampaign");
        t2.setName("DataAggregator");
        
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        
        t1.start();
        t2.start();
        
        try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("Inside main thread...");
	}

}


class EmailCampaign implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
			if(i==5) {
				Thread.currentThread().yield();
			}
		}
	}
}


class DataAggregator implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}