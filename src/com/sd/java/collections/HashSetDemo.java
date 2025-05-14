package com.sd.java.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
	
	private static void show(Collection c) {
		c.forEach(v -> {
			System.out.print(v+" ");
		});
		System.out.print('\n');
	}
	
	private static void compute() {
		Set<String> s = new HashSet<String>();
		s.add("hi");
		s.add("hi");
		s.add("hello");
		s.add("bye");
		show(s);
		
		Set<Car> s1= new HashSet<Car>();
		s1.add(new Car(1001, "Alto", 100000));
		s1.add(new Car(1001, "Alto", 100000));
		s1.add(new Car(1002, "Harrier", 2000000));
		show(s1);
		
		
	}

	public static void main(String[] args) {
        compute();
	}

}
