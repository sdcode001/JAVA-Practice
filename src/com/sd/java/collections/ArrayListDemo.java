package com.sd.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {
	
	private static void compute() {
	    List<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		list.set(0, 10);
	    
		list.add(1, 7);
		
		for(var it: list) {
			System.out.print(it+" ");
		}
		System.out.print('\n');
		
		System.out.println(list.get(2));
		
		list.remove(0);
		
		list.addAll(2, new ArrayList(Arrays.asList(9, 7, 6)));
		
	
		for(var it: list) {
			System.out.print(it+" ");
		}
		System.out.print('\n');
		
		List<Integer> subList = list.subList(2, 5);
		
		for(var it: subList) {
			System.out.print(it+" ");
		}
		System.out.print('\n');
	}

	public static void main(String[] args) {
		compute();

	}

}
