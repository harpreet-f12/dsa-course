package com.harpreet.dsa.sorting;

import java.util.Arrays;

public class QuickSort {

	public void quickSort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}

		quickSortRec(arr, 0, arr.length-1);
	}
	
	private void quickSortRec(int[] arr, int p, int r) {
		if(p >= r) {
			return;
		}

		int q = partition(arr, p, r); // q is the index of the pivot element
		quickSortRec(arr, p, q-1);
		quickSortRec(arr, q+1, r);
	}

	private int partition(int[] arr, int p, int r) {
		// We will consider element at the last index i.e. arr[r] as the pivot element.
		// counter i will run through the array length whereas j will keep track of 
		// elements lesser in value than the pivot element.
		
		int i=p, j=p-1;

		while(i < r) {
			if(arr[i] <= arr[r]) {
				j++;
				if(i != j) {
					//swap
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			i++;
		}

		// bring the pivot element at j+1 position by swapping arr[r] and arr[j+1]
		int tmp = arr[j+1];
		arr[j+1] = arr[r];
		arr[r] = tmp;

		// now all the elements to the left of pivot element are lesser in value
		// and the ones on the right are higher in value than the pivot element.
		return j+1; // return position of pivot element
	}
	
	public void demoQuickSort() {
		int[] arr = {10, 2, 5, 4, 8, 1};
		this.quickSort(arr);
		System.out.println("Quick sort on {10, 2, 5, 4, 8, 1}. Output: " + Arrays.toString(arr));

		int[] arr2 = {10, 2, 1, 3, 7, 5};
		this.quickSort(arr2);
		System.out.println("Quick sort on {10, 2, 1, 3, 7, 5}. Output: " + Arrays.toString(arr2));

		// already sorted array as input
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		this.quickSort(arr3);
		System.out.println("Quick sort on {1, 2, 3, 4, 5, 6}. Output: " + Arrays.toString(arr3));

		// empty array
		int[] arr4 = {};
		this.quickSort(arr4);
		System.out.println("Quick sort on {}. Output: " + Arrays.toString(arr4));

		int[] arr5 = null;
		this.quickSort(arr5);
		System.out.println("Quick sort on null array. Output: " + Arrays.toString(arr5));

		int[] arr6 = {10};
		this.quickSort(arr6);
		System.out.println("Quick sort on {10}. Output: " + Arrays.toString(arr6));
	}
	
}
