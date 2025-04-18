package com.sd.java.basics;

public class BoxedPrimitiveDemo {
	
	public static void compute() {
		Integer boxedInt = Integer.valueOf(8); // static factory
		Boolean boxedBoolean = Boolean.valueOf(true);
		Character boxedCharacter = Character.valueOf('c');
		Double boxedDouble = Double.valueOf(25.5);
		
//		System.out.println(boxedInt);
//		System.out.println(boxedBoolean);
//		System.out.println(boxedCharacter);
//		System.out.println(boxedDouble);
		
		Integer boxedInt1 = Integer.valueOf("8"); // except Character
		// Integer invalid = Integer.valueOf("eight"); 
		
		Integer boxedInt2 = new Integer(8);
		
		// unwrap: typeValue
		int primitiveInt = boxedInt.intValue();
		boolean primitiveBoxed = boxedBoolean.booleanValue();
		char primitiveChar = boxedCharacter.charValue();
		//System.out.println(primitiveInt);
		
		// 1. Parsing strings: parseType
		String data = "4004	Effective Java Programming Language Guide	2007	T	4.9";
		String[] items = data.split("\t");
		long id = Long.parseLong(items[0]);
		String title = items[1];
		int pubYear = Integer.parseInt(items[2]);
		char genre = items[3].charAt(0);
		double rating = Double.parseDouble(items[4]);
		
		System.out.println(id);
		System.out.println(title);
		System.out.println(pubYear);
		System.out.println(genre);
		System.out.println(rating);
		
		Integer boxedPubYear = Integer.valueOf(items[2]);
		
		// 2. MIN_VALUE & MAX_VALUE
		
		// 3. utility method
		boolean isLetter = Character.isLetter(genre);
		boolean isDigit = Character.isDigit(genre);
		boolean isLetterOrDigit = Character.isLetterOrDigit(genre);
		boolean isUpperCase = Character.isUpperCase(genre);
		
		System.out.println(isLetter);
		System.out.println(isDigit);
		System.out.println(isLetterOrDigit);
		System.out.println(isUpperCase);
		
		boolean isNan = Double.isNaN(0.0/0.0);
		System.out.println(isNan);
		
		String binary = Integer.toBinaryString(8);
		System.out.println(binary);
		String pubYearAsString = Integer.toString(pubYear);
		
		//auto boxing and unboxing
		Integer boxed = 35;
		System.out.println("boxed = " + boxed);
		int j = boxed;
		System.out.println("j = " + j);
	}

	public static void main(String[] args) {
           compute();
	}

}
