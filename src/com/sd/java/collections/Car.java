package com.sd.java.collections;

public class Car {
    private int id;
    private String name;
    private int cost;
    
	public Car(int id, String name, int cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}
    
	@Override
	public int hashCode() {
		return name.hashCode() + id + cost;
	}
	
	@Override 
	public boolean equals(Object o) {
	    return ((Car)o).name==this.name && ((Car)o).id==this.id && ((Car)o).cost==this.cost;
	}
}
