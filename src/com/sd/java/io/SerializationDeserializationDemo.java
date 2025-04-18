package com.sd.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class SerializationDeserializationDemo {
	public static class Location implements Serializable {
		private String city;
		private int pin;
		
		public Location(int pin, String city) {
			this.pin = pin;
			this.city = city;
		}
		
		@Override
		public String toString() {
			return "Location [city=" + city + ", pin=" + pin + "]";
		}
	}
	
    private static class Student implements Serializable {
    	static final long serialVersionUID = 100000; //to avoid versioning issue
 		private transient int id;
 		private static int grade = 5;
    	private String name;
    	private int age;
    	private double rating;
    	private Location location;
    	
    	public Student(int id, String name, int age, double rating, Location location) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.rating = rating;
			this.location = location;
		}
    	
    	@Override
		public String toString() {
			return "Student [id=" + id + ", grade="+ grade +", name=" + name + ", age=" + age + ", rating=" + rating + ", location="
					+ location + "]";
		}
    }
    
    private static void serialize(Object obj) {
    	try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\JAVA_Workshop\\project1\\src\\com\\sd\\java\\io\\object.ser")))){
    		out.writeObject(obj);
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private static Object deserialize(String fileName) {
    	try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("D:\\JAVA_Workshop\\project1\\src\\com\\sd\\java\\io\\"+fileName)))){
    		Object deserilizedObj = in.readObject();
    	    String str = deserilizedObj.toString();
    	    System.out.println("Deserilized string: "+str); 
    	    return deserilizedObj;
    	}catch (ClassNotFoundException e) {
    	    e.printStackTrace();  
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    	return null;
    }
    
	
	public static void main(String[] args) {
        Student s = new Student(1001, "Souvik", 23, 9.9, new Location(733129, "Kaliyaganj"));
        System.out.println("Before serialization: " + s);
        //serialize(s);
        Student ds = (Student)deserialize("object.ser");
        System.out.println("After deserialization: " + ds);
        
	}

}
