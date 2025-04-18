package com.sd.java.basics;

import java.util.Scanner;

public class ControlflowDemo {

	public static void compute() {
		//switch statement
		String season = null;
		int month = 9;
		
		switch(month) {
		  case 1,2,3 -> {
			  season = "Summer";
			  System.out.println("Season = "+season);
		  }
		  case 4,5 -> {
			  season = "Winter";
			  System.out.println("Season = "+season);
		  }
		  case 6,7,8,9 -> {
			  season = "Spring";
			  System.out.println("Season = "+season);
		  }
		  case 10 -> {
			  season = "Autumn";
			  System.out.println("Season = "+season);
		  }
		  default -> {
			  season = "Unknown";
			  System.out.println("Season = "+season);
		  }
		}
		
		//assignment using switch
		int n = 4;
		String level = switch(n) {
		   case 0 -> "Level ground";
		   case 1 -> "Level 1";
		   case 2,3,4,5 -> "Level 2";
		   default -> "Sky";
		};
		System.out.println("level = "+level);
		
		//Ternary operator
		int age = 30;
		String ageType = (age<10) ? "Child" : (age>=10 && age<=18) ? "Boy" : (age>18 && age<30) ? "Youth" : "Men";
		System.out.println("AgeType = "+ageType);
		
		//for-each loop
		int[] arr = new int[] {3,4,5,6,7,8};
		for(int v: arr) {
			System.out.println(v);
		}
		
		//do-while loop
		//do-while loop will execute at least once.
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Menu:");
			System.out.println("1. Pizza: $12");
			System.out.println("2. Burger: $8");
			System.out.println("3. Coffee: $3");
			System.out.println("4. Soft Drink: $3");
			System.out.println("5. Cake: $5");
				
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
		}while(choice<1 || choice>5);
			
	}
	
	public static void blockDemo() {
		{
			Student s = new Student();
			s.name = "Souvik";
			s.age = 23;
			s.degree = 'B';
			s.compute();
		}
		
		{
			Student s = new Student();
			s.name = "Souvik";
			s.age = 23;
			s.degree = 'B';
			s.compute();
		}
	}
	
	public static void main(String[] args) {
          compute();
          //blockDemo();
	}

}
