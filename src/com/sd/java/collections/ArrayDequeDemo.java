package com.sd.java.collections;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class ArrayDequeDemo {
	
	private static void show(Collection c) {
		c.forEach(v -> {
		    System.out.print(v+" ");
		});
		System.out.print('\n');
	}
	
	private static void compute() {
		Deque<Integer> dq = new ArrayDeque<>();
		
		dq.add(1);
		dq.add(2);
		dq.add(3);
		dq.add(4);
		dq.add(5);
		
		show(dq);
		
		int e = dq.poll();
		
		show(dq);

		System.out.println("peak: " + dq.peek());
		
		show(dq);
		
		dq.addFirst(1);
		
		show(dq);
		
		int e1 = dq.removeLast();
		
		show(dq);
		
	}
	
	public static void main(String[] args) {
		compute();
	}
}
