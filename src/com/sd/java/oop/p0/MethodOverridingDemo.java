package com.sd.java.oop.p0;

public class MethodOverridingDemo extends User {
	
	public int id = 5;
	
	public void printId() {
		System.out.println("id: " + id);
		System.out.println("super.id: " + super.id); //hidden field - id of User
	}
	
	public Review postAReview(String reviewText) {
	    System.out.println("MethodOverridingDemo: postAReview()");
	    Review review = super.postAReview(reviewText);
	    review.setApproveStatus(true);
	    return review;
	}

	public static void main(String[] args) {
		MethodOverridingDemo objTest = new MethodOverridingDemo();
		Review review = objTest.postAReview("It's good");
		objTest.printId();
	}

}
