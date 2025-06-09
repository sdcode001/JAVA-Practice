package com.sd.java.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenericMethodDemo<E> {
	
	public static <T> T go(T obj) {
		return obj;
	}
	
	public <T, E> void go1(T p1, E p2) {
		System.out.println("go1: "+p1+", "+p2);
	}

	public <T extends List & Serializable> void go2(T obj){
		System.out.println("go2: "+obj);
	}
	
	public <T extends E> T go3(T obj) {
		return obj;
	}
	
	public static <T> List<T> go4() {
		List<T> val = new ArrayList<>();
		return val;
	}
	
	
	public static void main(String[] args) {
        String a = go("souvik");
        
        GenericMethodDemo<List<Integer>> obj = new GenericMethodDemo<>();
        obj.go1("Souvik", new ArrayList<Integer>());
        
        obj.go2(new ArrayList());
        
        List<Integer> b = obj.go3(new ArrayList<Integer>());
        
        List<Double> list = go4();  //Inferred type - Double
        
        List<Integer> list1 = GenericMethodDemo.<Integer>go4(); //Explicit parameter type decleration
        
        
	}

}