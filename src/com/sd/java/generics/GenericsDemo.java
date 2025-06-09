package com.sd.java.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericsDemo<T extends List & Serializable> {
	private T a;
	
	public int len() {
		return a.size();
	}
	
	//Integer, Double are sub-type of Number
	//List is Type Invariance
	public void go(List<Number> items) {
		items.add(3.5);
	}
	
	//Integer, Double are sub-type of Number
	//Array is Type Covariance
	public void go1(Number[] items) {
		items[0]=4.5;
	}

	public static void main(String[] args) {
       Container<String> s1 = new Store<>();
       s1.set("Souvik");
       String r1 = s1.get();
       
       Container<Date> s2 = new Store<>();
       s2.set(new Date());
       Date r2 = s2.get();
       
       Container<List<String>> s3 = new Store<>();
       s3.set(new ArrayList<String>());
       List<String> r3 = s3.get();
       
       //Bounded type demo
       GenericsDemo<ArrayList> gd = new GenericsDemo<>();
       
       //Invariance, compile time type safety
       gd.go(new ArrayList<Integer>());
       
       //Covarience, No compile time type safety
       gd.go1(new Integer[1]);
       
	}

}


class Store<T> implements Container<T>{
    private T a;
    
	@Override
	public void set(T a) {
		this.a = a;
	}

	@Override
	public T get() {
		return this.a;
	}
}

interface Container<T> {
	void set(T a);
	T get();
}
