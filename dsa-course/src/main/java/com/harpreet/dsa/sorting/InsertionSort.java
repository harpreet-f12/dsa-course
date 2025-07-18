package com.harpreet.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public void insertionSort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}

		for(int i = 1; i < arr.length; i++) {
			int val = arr[i];
			int j = i-1;
			for(; j >= 0; j--) {
				if(val < arr[j]) {
					arr[j+1] = arr[j];
				}
				else {
					break;
				}
			}

			arr[j+1] = val;
		}
	}

	public void demoInsertionSort() {
		int[] arr = {10, 2, 5, 3, 7, 8};
		this.insertionSort(arr);
		System.out.println("Insertion sort on {10, 2, 5, 3, 7, 8}. Output: " + Arrays.toString(arr));
		
		int[] arr2 = {10, 2, 1, 3, 7, 5};
		this.insertionSort(arr2);
		System.out.println("Insertion sort on {10, 2, 1, 3, 7, 5}. Output: " + Arrays.toString(arr2));
		
		// already sorted array as input
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		this.insertionSort(arr3);
		System.out.println("Insertion sort on {1, 2, 3, 4, 5, 6}. Output: " + Arrays.toString(arr3));

		// empty array
		int[] arr4 = {};
		this.insertionSort(arr4);
		System.out.println("Insertion sort on {}. Output: " + Arrays.toString(arr4));

		int[] arr5 = null;
		this.insertionSort(arr5);
		System.out.println("Insertion sort on null array. Output: " + Arrays.toString(arr5));

		int[] arr6 = {10};
		this.insertionSort(arr6);
		System.out.println("Insertion sort on {10}. Output: " + Arrays.toString(arr6));
	}

}
