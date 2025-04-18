package com.sd.java.oop.p0;

public class ObjectClassDemo implements Cloneable{
	private int id = 5;
	private String name = "Souvik Dey";
	private int age = 23;
	
	@Override
	public String toString() {
		return "ObjectClassDemo: id="+this.id+", name="+this.name+", age="+this.age;
	}
	
	public static void main(String[] args) {
		ObjectClassDemo obj = new ObjectClassDemo();
		ObjectClassDemo obj1 = obj;
		try {
			ObjectClassDemo obj2 = (ObjectClassDemo)obj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(obj);
		System.out.println(obj.hashCode());
		System.out.println(obj1.hashCode());
		System.out.println(obj.getClass());
		System.out.println(obj.getClass().getMethods());
	}
     
}
