package com.sd.java.nestedClass;

public class Item {
	private int id;
	private String name;
	
    public Item(int id, String name) {
    	this.id = id;
    	this.name = name;
    }

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + "]";
	}
}
