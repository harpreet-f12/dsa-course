package com.harpreet.dsa;

import java.util.Arrays;

public class RadixSort {

	public void radixSort(int[] arr) {
		// validate input
	    if (arr == null || arr.length == 0) {
	    	return;
	    }
	            
		// validate input and find maximum value
		int max = 0;
		for(int val : arr) {
			if(val < 0) {
				throw new IllegalArgumentException("Input must contain non-negative integers");
			}
	
			if(val > max) {
				max = val;
			}
		}
	    
	    // Apply counting sort for each digit. 
	    // exp stands for exponent and represents 1's place, 10's place...
	    for (int exp = 1; max / exp > 0; exp *= 10) {
	        int[] digits = extractDigits(arr, exp);
	        countingSort(digits, arr);
	    }
	}    
	
	private int[] extractDigits(int[] arr, int exp) {
	    int[] digits = new int[arr.length];
	    for (int i = 0; i < arr.length; i++) {
	        digits[i] = (arr[i] / exp) % 10;
	    }
	    return digits;
	}
	
	private void countingSort(int[] digits, int[] arr) {
	    int[] output = new int[arr.length];
	    int[] counts = new int[10]; // digit range is 0-9
	
	    // count occurrences of each digit
	    for (int digit : digits) {
	        counts[digit]++;
	    }
	
	    // convert counts to positions
	    for (int i=1; i < counts.length; i++) {
	        counts[i] += counts[i-1];
	    }
	
	    // build the output array
	    for (int i=arr.length-1; i >= 0; i--) {
	        int digit = digits[i];
	        output[--counts[digit]] = arr[i];
	    }
	
	    // copy the sorted numbers back to the original array
	    System.arraycopy(output, 0, arr, 0, arr.length);
	}
    
	public void demoRadixSort() {
		int[] arr = {111, 121, 101, 320};
		this.radixSort(arr);
		System.out.println("Radix sort on {111, 121, 101, 320}. Output: " + Arrays.toString(arr));
			
		// digits will variable length
		int[] arr2 = {12, 3346, 143, 685, 786, 111, 2, 0};
		this.radixSort(arr2);
		System.out.println("Radix sort on {12, 3346, 143, 685, 786, 111, 2, 0}. Output: " + Arrays.toString(arr2));
		
		// already sorted array as input
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		this.radixSort(arr3);
		System.out.println("Radix sort on {1, 2, 3, 4, 5, 6}. Output: " + Arrays.toString(arr3));

		// empty array
		int[] arr4 = {};
		this.radixSort(arr4);
		System.out.println("Radix sort on {}. Output: " + Arrays.toString(arr4));

		// null array
		int[] arr5 = null;
		this.radixSort(arr5);
		System.out.println("Radix sort on null array. Output: " + Arrays.toString(arr5));

		int[] arr6 = {10};
		this.radixSort(arr6);
		System.out.println("Radix sort on {10}. Output: " + Arrays.toString(arr6));
	}
}
