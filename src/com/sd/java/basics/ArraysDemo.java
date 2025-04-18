package com.sd.java.basics;

public class ArraysDemo {
	
	static int[] arr2;
	
	public static void compute() {
		//1D Array
		int[] arr = new int[] {1,2,3,4};
		int[] arr1 = {1,2,3,4};
		arr2 = new int[3]; //re-initialize
		System.out.println("arr2.length = " + arr2.length);
		
		//2D Array
		int[][] arr3 = new int[3][2];
		arr3[0][0]=2;
		arr3[0][1]=3;
		
		int[][] arr4 = new int[][] {}; // 0,0 dimension 2D array;
		int[][] arr5 = new int[3][];  //2D array with irregular row sizes
		arr5[0] = new int[5];
		arr5[1] = new int[3];
		arr5[2] = new int[2];
		System.out.println("arr5.length = " + arr5.length);
		System.out.println("arr5[0].length = " + arr5[0].length);
		
		
	}

	public static void main(String[] args) {
       compute();
	}

}
