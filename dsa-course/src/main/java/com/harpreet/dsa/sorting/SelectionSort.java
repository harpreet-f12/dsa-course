package com.harpreet.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public void selectionSort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}

		for(int i = 0; i < arr.length-1; i++) {
			int minIndex = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			// At this point, minIndex points to index of smallest element.
			// Swap it with the first element
			if(minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	public void demoSelectionSort() {
		int[] arr = {10, 2,	5, 4, 8, 1};
		this.selectionSort(arr);
		System.out.println("Selection sort on {10, 2, 5, 4, 8, 1}. Output: " + Arrays.toString(arr));

		int[] arr2 = {10, 2};
		this.selectionSort(arr2);
		System.out.println("Selection sort on {10, 2}. Output: " + Arrays.toString(arr2));

		// already sorted array as input
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		this.selectionSort(arr3);
		System.out.println("Selection sort on {1, 2, 3, 4, 5, 6}. Output: " + Arrays.toString(arr3));

		// empty array
		int[] arr4 = {};
		this.selectionSort(arr4);
		System.out.println("Selection sort on {}. Output: " + Arrays.toString(arr4));

		int[] arr5 = null;
		this.selectionSort(arr5);
		System.out.println("Selection sort on null array. Output: " + Arrays.toString(arr5));

		int[] arr6 = {10};
		this.selectionSort(arr6);
		System.out.println("Selection sort on {10}. Output: " + Arrays.toString(arr6));
	}

}
