package com.sd.java.oop.p0;

public class Review {
   private String reviewText;
   private boolean isApproved;
   
   public Review(String text) {
	   this.reviewText = text;
   }
   
   public String getReview() {
	   return this.reviewText;
   }
   
   public void setApproveStatus(boolean status) {
	   this.isApproved = status;
   }
}
