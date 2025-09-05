package com.harpreet.dsa.binarysearch;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		
		int[] arr = {10, 20, 30, 40, 50};
		int left = 0;
		int right = arr.length-1;
		int target = 20;
		
		int index = bs.binarySearch(arr, target, left, right);
		print(target, index, arr);
		
		target = 5;
		index = bs.binarySearch(arr, target, left, right);
		print(target, index, arr);
		
		target = 35;
		index = bs.binarySearch(arr, target, left, right);
		print(target, index, arr);
		
		target = 50;
		index = bs.binarySearch(arr, target, left, right);
		print(target, index, arr);		
	}
	
	public static void print(int target, int index, int[] arr) {
		if(index != -1) {
			System.out.println("Target " + target + " found at index " + index + " in array " 
								+ Arrays.toString(arr));
		}
		else {
			System.out.println("Target " + target + " not found in array " + Arrays.toString(arr) );
		}	
	}

}
