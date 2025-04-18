package com.sd.java.collections;

import java.util.ArrayList;

public class ArrayListDemo {
	
	private static void compute() {
		ArrayList<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
	
		
		for(var it: list) {
			System.out.print(it);
		}
		System.out.print('\n');
		
		System.out.println(list.get(2));
		
		list.remove(0);
		
	
		for(var it: list) {
			System.out.print(it);
		}
		System.out.print('\n');
		
		
	}

	public static void main(String[] args) {
		compute();

	}

}
