package com.sd.java.enums;

public class Book {
    private int id;
    private String name;
	
	//Nested enum
	public enum Genre {
		HORROR(20), 
		BIOGRAPHY(15), 
		FRICTION(12);
		
		private int minAgeToRead;
		
		private Genre(int minAgeToRead) {
			this.minAgeToRead = minAgeToRead;
		}
		
		public int getMinAgeToRead() {
			return this.minAgeToRead;
		}
	}

	public Book(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
