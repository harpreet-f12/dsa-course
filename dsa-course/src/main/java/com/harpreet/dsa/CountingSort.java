package com.harpreet.dsa;

import java.util.Arrays;

public class CountingSort {

	public int[] countingSort(int[] arr) {
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Input array must not be null or empty.");
		}
	
		// validate input and find maximum value k
		int k = 0;
		for(int val : arr) {
			if(val < 0) {
				throw new IllegalArgumentException("Input must contain non-negative integers.");
			}
	
			if(val > k) {
				k = val;
			}
		}
	
		// initialize counts array. default values are 0.
		int[] counts = new int[k+1];
	
		// run over input array and update counts array
		for(int val : arr) {
			counts[val]++;
		}
	
		// update counts array to store positions
		for(int i=1; i < counts.length; i++) {
			counts[i] += counts[i-1];
		}
	
		// fill outputArr. The reason counter i starts from the end
		// is to make it a stable sort.
		int[] outputArr = new int[arr.length];
		for(int i=arr.length-1; i >= 0; i--) {
			int val = arr[i];
			outputArr[--counts[val]] = val;
		}
	
		return outputArr;
	}

	public void demoCountingSort() {
		// normal input
		try {
			int[] arr = {3, 2, 1, 6, 4};
			int[] sortedArr = countingSort(arr);		
			System.out.println("Counting sort on {3, 2, 1, 6, 4}. Output: " + Arrays.toString(sortedArr));
		} 
		catch (IllegalArgumentException e) {
	        System.out.println("Exception calling Couting sort on {3, 2, 1, 6, 4}. " + e.getMessage());
	    }
				    
		// bigger input
		try {
			int[] arr2 = {59, 5, 10, 10, 4, 10, 30};
			int[] sortedArr2 = countingSort(arr2);
			System.out.println("Counting sort on {59, 5, 10, 10, 4, 10, 30}. Output: " + Arrays.toString(sortedArr2));
		}
		catch (IllegalArgumentException e) {
	        System.out.println("Exception calling Couting sort on {59, 5, 10, 10, 4, 10, 30}. " + e.getMessage());
	    }
		
		// empty array
		try {
			int[] arr3 = {};
			int[] sortedArr3 = this.countingSort(arr3);
			System.out.println("Counting sort on {}. Output: " + Arrays.toString(sortedArr3));
		}
		catch (IllegalArgumentException e) {
	        System.out.println("Counting sort on {}. Exception raised. " + e.getMessage());
	    }		

		// null array
		try { 
			int[] arr4 = null;
			int[] sortedArr4 = this.countingSort(arr4);
			System.out.println("Counting sort on null array. Output: " + Arrays.toString(sortedArr4));
		}
		catch (IllegalArgumentException e) {
	        System.out.println("Counting sort on null array. Exception raised. " + e.getMessage());
	    }
	}

}
