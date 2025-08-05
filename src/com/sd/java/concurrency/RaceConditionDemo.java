package com.sd.java.concurrency;

public class RaceConditionDemo {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
        account.setBalance(100);
        
        Thread t1 = new Thread(account);
        Thread t2 = new Thread(account);
        
        t1.setName("John");
        t2.setName("Anita");
        
        t1.start();
        t2.start();
	}

}


class BankAccount implements Runnable {
	private int balance;

	@Override
	public void run() {
		this.withdrawlAmount(75);
		if(this.balance<0) {
			System.out.println("Money Overdrawn!!!");
		}
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public synchronized void withdrawlAmount(int amount) {
		System.out.println(Thread.currentThread().getName()+" started withdrawl...");
		if(this.balance>=amount) {
			this.balance-=amount;
			System.out.println(Thread.currentThread().getName()+" withdrawl done...");
		}
		else {
			System.out.println("Sorry! not enough money for "+Thread.currentThread().getName());
		}
	}
	
}
