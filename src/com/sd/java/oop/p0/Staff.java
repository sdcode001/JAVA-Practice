package com.sd.java.oop.p0;

public class Staff extends User{
	public Staff() {
		System.out.println("Staff constructor");
	}
	
	
	public void printUserType() {
	   System.out.println("Staff");
    }
   
    public void postAReview() {
	   System.out.println("Staff: postAReview()");
    }
}
