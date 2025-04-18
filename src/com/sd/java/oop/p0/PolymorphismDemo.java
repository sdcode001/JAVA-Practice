package com.sd.java.oop.p0;

public class PolymorphismDemo {
	
	private static void approveReview(Staff s) {
		if(s instanceof Editor) {
			((Editor)s).approveReview();
		}
		else {
			System.out.println("Invalid object type passed..");
		}
	}

	public static void main(String[] args) {
		User u = new Staff();
        u.postAReview("It's good");
        u.saveWeblink();
        //u.approveReview();  //compile-time error
        
        Staff s1 = new Staff();
        Editor s2 = new Editor();
        approveReview(s1);
	}

}
