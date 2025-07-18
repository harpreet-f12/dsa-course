package com.harpreet.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public void bubbleSort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}

		for(int i = 0; i < arr.length-1; i++) {
			for(int j = arr.length-1; j > i; j--) {
				if(arr[j] < arr[j-1]) {
					//swap
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}	

	public void demoBubbleSort() {
		int[] arr = {10, 2, 5, 3, 7, 8};
		this.bubbleSort(arr);
		System.out.println("Bubble sort on {10, 2, 5, 3, 7, 8}. Output: " + Arrays.toString(arr));

		int[] arr2 = {10, 2, 1, 3, 7, 5};
		this.bubbleSort(arr2);
		System.out.println("Bubble sort on {10, 2, 1, 3, 7, 5}. Output: " + Arrays.toString(arr2));

		// already sorted array as input
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		this.bubbleSort(arr3);
		System.out.println("Bubble sort on {1, 2, 3, 4, 5, 6}. Output: " + Arrays.toString(arr3));

		// empty array
		int[] arr4 = {};
		this.bubbleSort(arr4);
		System.out.println("Bubble sort on {}. Output: " + Arrays.toString(arr4));

		int[] arr5 = null;
		this.bubbleSort(arr5);
		System.out.println("Bubble sort on null array. Output: " + Arrays.toString(arr5));

		int[] arr6 = {10};
		this.bubbleSort(arr6);
		System.out.println("Bubble sort on {10}. Output: " + Arrays.toString(arr6));
	}

}
