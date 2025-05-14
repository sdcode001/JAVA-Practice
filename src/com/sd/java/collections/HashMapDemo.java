package com.sd.java.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	
	private static void show(Map m) {
		m.forEach((key, value) -> {
			System.out.print(key+":"+value+", ");
		});
		System.out.print('\n');
	}
	
	private static void compute() {
		HashMap<Integer, String> map = new HashMap();
		map.put(2, "car");
		map.put(3, "truck");
		map.put(4, "bus");
		map.put(5, "bike");
		show(map);
		
		System.out.println(map.get(5));
		
		map.remove(3);
		show(map);
		
		if(map.containsKey(4)) {
			map.replace(4, "bicycle");
		}
		show(map);
		
		//iterate in map
		Set<Map.Entry<Integer, String>> entries = map.entrySet();
		entries.forEach(v -> {
			System.out.print(v.getKey()+":"+v.getValue()+", ");
		});
		System.out.print('\n');
		
		
	}

	public static void main(String[] args) {
		compute();

	}

}
