package com.sd.java.enums;

public enum BookGenreCustom {
	HORROR(20), 
	BIOGRAPHY(15), 
	FRICTION(12);
	
	private int minAgeToRead;
	
	private BookGenreCustom(int minAgeToRead) {
		this.minAgeToRead = minAgeToRead;
	}
	
	public int getMinAgeToRead() {
		return this.minAgeToRead;
	}
	
	//Constant specific behavior(using switch statement)
	//Example- Check if a BookGenre enum is kid friendly or not by age.
	public boolean isKidFriendlyFor(int age) {
		switch(this) {
		  case HORROR : return age >= this.minAgeToRead;
		  case BIOGRAPHY : return false;
		  default: return false;
		}
	}
	
}
