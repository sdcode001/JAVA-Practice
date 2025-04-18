package com.sd.java.oop.p0;

public class User {
   public int id = 2;
   
   public User() {
		System.out.println("User constructor");
	}
   
   public void printUserType() {
	   System.out.println("User");
   }
   
   public void saveWeblink() {
	   System.out.println("User: saveWeblink()");
	   this.postAReview("");
   }
   
   public Review postAReview(String reviewText) {
	   System.out.println("User: postAReview()");
	   return new Review(reviewText);
   }
}
