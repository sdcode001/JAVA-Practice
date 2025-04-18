package com.sd.java.basics;

public class VariableScopeDemo {
	  static int computeCount;
	  
      int id;
	  String name;
	  String gender;
	  int age;
	  boolean international;
	  double tuitionFees = 12000.0, internationalFees = 5000.0;
	
	  void compute() {	
 	      computeCount = computeCount + 1;
		  int nextId = id + 1;		  
		  
		  if (international) {
		      tuitionFees = tuitionFees + internationalFees;
		  }
		
	      System.out.println("\nid: " + id);
		  System.out.println("nextId: " + nextId);
		  System.out.println("name: " + name);
		  System.out.println("gender: " + gender);
		  System.out.println("age: " + age);
		  System.out.println("tuitionFees: " + tuitionFees);
		  System.out.println("computeCount: " + computeCount);
	  }
	  
	
	  public static void main(String[] args) {
	      VariableScopeDemo student1 = new VariableScopeDemo();
		  student1.id = 1000;	
	      student1.name = "John";
	      student1.gender = "male";
	      student1.age = 18;	  
	      student1.international = false;
		  student1.compute();
		  
		  VariableScopeDemo student2 = new VariableScopeDemo();
		  student2.id = 1001;	
	      student2.name = "Raj";
	      student2.gender = "male";
	      student2.age = 21;	  
	      student2.international = true;
		  student2.compute();
		  
		  VariableScopeDemo student3 = new VariableScopeDemo();
		  student3.id = 1002;
		  student3.name = "Anita";
		  student3.gender = "female";
		  student3.age = 20;
		  student3.international = true;
		  student3.compute();
		  
		  System.out.println("Student.computeCount: " + VariableScopeDemo.computeCount);
		  System.out.println("student3.computeCount: " + student3.computeCount);
	  }
}
