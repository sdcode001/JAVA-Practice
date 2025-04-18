package com.sd.java.basics;

public class StringDemo {

	public static void main(String[] args) {
		//String interning
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1==s2);
        System.out.println(s1==s2.intern());
        
        
        //String class methods.
        String s = "hello world!";
		System.out.println("s: " + s);
		System.out.println("\ns.length(): " + s.length());
		System.out.println("s.isEmpty(): " + s.isEmpty());
		// Comparison
		System.out.println("\ns.equals(\"HELLO WORLD!\"): " + s.equals("HELLO WORLD!"));
		System.out.println("s.equalsIgnoreCase(\"HELLO WORLD!\"): " + s.equalsIgnoreCase("HELLO WORLD!"));
		System.out.println("s.compareTo(\"HELLO WORLD!\"): " + s.compareTo("HELLO WORLD!"));
		// Searching
		System.out.println("\ns.contains(\"HELLO WORLD!\"): " + s.contains("HELLO WORLD!"));
		System.out.println("s.contains(\"world!\"): " + s.contains("world!"));
		System.out.println("s.startsWith(\"HELLO WORLD!\"): " + s.startsWith("HELLO WORLD!"));
		System.out.println("s.startsWith(\"hello world!\"): " + s.startsWith("hello world!"));
		System.out.println("s.endsWith(\"!\"): " + s.endsWith("!"));
		System.out.println("s.indexOf(\"lo\"): " + s.indexOf("lo"));
		System.out.println("s.indexOf(\"o\"): " + s.indexOf('o'));
		System.out.println("s.lastIndexOf(\"o\"): " + s.lastIndexOf('o'));
		// Examining individual characters
		System.out.println("\ns.charAt(4): " + s.charAt(4));
		// Extracting substrings
		System.out.println("\ns.substring(4): " + s.substring(4));
		System.out.println("s.substring(4, 9): " + s.substring(4, 9)); //start inclusive & end exclusive
		// Case conversions (Note: String is immutable. So, only a copy is returned)
		System.out.println("\ns.toUpperCase(): " + s.toUpperCase());
		System.out.println("s.toLowerCase(): " + s.toLowerCase());
		System.out.println("\ns.trim(): " + s.trim()); // returns a copy of string after trimming any leading & trailing white spaces
		// Replace (e.g., replace comma's with white-space)
		System.out.println("\ns.replaceAll(\"o\", \"r\"): " + s.replaceAll("o", "r"));
		// Split (e.g., split a document into words or split a line of text by tab or comma or white space)
		System.out.println("\ns.split(\"o\"): ");
		String[] sa = s.split("o");
		for (String temp : sa) { System.out.println(temp); }
		// Static method (includes overloaded methods)
		System.out.println("\nString.valueOf(1.3): " + String.valueOf(1.3));
		
		
		//String Concatenation
		String s3 = "hello"+"world";;
		System.out.println("\n" + s3);
		String s4 = "hello"+"world"+125;
		System.out.println("\n" + s4);
		String s5 = "hello"+"world"+125+25.5; //left to right computation.
		System.out.println("\n" + s5);
		String s6 = 125+25.5+"hello"+"world"; //left to right computation.
		System.out.println("\n" + s6);
		
		
		//StringBuilder
		StringBuilder sb = new StringBuilder("hello");
		sb.append(" world");
		System.out.println("\nsb.toString() = " + sb.toString());
		sb.delete(2, 5);
		System.out.println("sb.toString() = " + sb.toString());
		sb.insert(2, "yyy");
		System.out.println("sb.toString() = " + sb.toString());
		sb.setCharAt(2, 'e');
		String s7 = sb.toString();
		System.out.println("sb.toString() = " + s7);
		
		
	} 

}
