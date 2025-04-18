package com.sd.java.oop.p0;

public class EncapsulationDemo {
	private int id;
	private String name;
	private int age;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		EncapsulationDemo obj = new EncapsulationDemo();
		obj.setAge(23);
		obj.setName("Souvik Dey");
		obj.setId(1001);
		
		System.out.println(obj.getName());
		System.out.println(obj.getAge());
		System.out.println(obj.getId());
	}

}
