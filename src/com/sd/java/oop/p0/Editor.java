package com.sd.java.oop.p0;

public class Editor extends Staff{
	public Editor() {
		System.out.println("Editor constructor");
	}
	
	public Editor(int id) {
		System.out.println("Editor(int id) constructor");
	}
	
	public void printUserType() {
		System.out.println("Editor");
	}
	
	public void approveReview() {
		System.out.println("Editor: approveReview()");
	}
}
