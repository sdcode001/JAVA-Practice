package com.sd.java.enums;

import com.sd.java.enums.Book.Genre;


public class EnumDemo {

	private static int getVal(String constantName) {
		BookGenre val = BookGenre.valueOf(constantName);
		return val.ordinal();
	}

	public static void main(String[] args) {
		BookGenre[] list = BookGenre.values();
		//get Enum constant name, ordinal value
		for(BookGenre ele: list) {
			System.out.println("name: "+ele.name()+", ordinal: "+ele.ordinal());
		}
		//get a Enum constant instance by name
		BookGenre val = BookGenre.valueOf("FRICTION");
		//compare the ordinal values
		System.out.println("compareTo(): " + val.compareTo(BookGenre.SCIENTIFIC));
		
		
		//Enum with state and behaviour.....
		BookGenreCustom[] list1 = BookGenreCustom.values();
		//get Enum constant name, ordinal value
		for(BookGenreCustom ele: list1) {
			System.out.println("name: "+ele.name()+", ordinal: "+ele.ordinal());
		}
		
		BookGenreCustom val1 = BookGenreCustom.HORROR;
		System.out.println("HORROR.getMinAgeToRead(): "+val1.getMinAgeToRead());
		
		//kid friendly age validity check
		System.out.println("HORROR.isKidFriendlyFor(): " + BookGenreCustom.HORROR.isKidFriendlyFor(30));
		
		
		//Nested enum demo.....
		Genre biography = Book.Genre.BIOGRAPHY;
		System.out.println("biography.name(): "+biography.name()+", biography.ordinal(): "+biography.ordinal());
		
	}
     
}
