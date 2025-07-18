package com.harpreet.dsa.sorting;

import java.util.Arrays;

public class MergeSort {

	public void mergeSort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}

		mergeSortRec(arr, 0, arr.length-1);
	}

	// Input array arr starts at index p and ends at r
	private void mergeSortRec(int[] arr, int p, int r) {
		if(p >= r) {
			return;
		}

		// Split the array and call the method recursively on both left and right subarrays
		int q = (p+r)/2;
		mergeSortRec(arr, p, q);
		mergeSortRec(arr, q+1, r);

		// Both left and right subarrays are individually sorted at this point. Merge them in
		// sorted order.
		merge(arr, p, q, r);
	}

	private void merge(int[] arr, int p, int q, int r) {
		// Merge the two subarrays.
		// First subarray is from [p, q]. Second is from [q+1, r]
		int ctr1=p, ctr2=q+1;
		int len = r-p+1;
		int[] arr2 = new int[len];
		int arr2Index = 0;

		while(ctr1 <= q && ctr2 <=r) {
			if(arr[ctr1] <= arr[ctr2]) {
				arr2[arr2Index++] = arr[ctr1++];
			}
			else {
				arr2[arr2Index++] = arr[ctr2++];
			}
		}

		// At this point, either ctr1 has reached q or ctr2 has reached r

		// Copy the remaining elements from first subarray if any
		while(ctr1 <= q) {
			arr2[arr2Index++] = arr[ctr1++];
		}

		// Copy the remaining elements from second subarray if any
		while(ctr2 <= r) {
			arr2[arr2Index++] = arr[ctr2++];
		}

		// copy arr2 back into arr
		for(int i=0; i < len; i++) {
			arr[p+i] = arr2[i];
		}

	}

	public void demoMergeSort() {
		int[] arr = {10, 2,	5, 4, 8, 1};
		this.mergeSort(arr);
		System.out.println("Merge sort on {10, 2, 5, 4, 8, 1}. Output: " + Arrays.toString(arr));

		int[] arr2 = {10, 2, 1, 3, 7, 5};
		this.mergeSort(arr2);
		System.out.println("Merge sort on {10, 2, 1, 3, 7, 5}. Output: " + Arrays.toString(arr2));

		// already sorted array as input
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		this.mergeSort(arr3);
		System.out.println("Merge sort on {1, 2, 3, 4, 5, 6}. Output: " + Arrays.toString(arr3));

		// empty array
		int[] arr4 = {};
		this.mergeSort(arr4);
		System.out.println("Merge sort on {}. Output: " + Arrays.toString(arr4));

		int[] arr5 = null;
		this.mergeSort(arr5);
		System.out.println("Merge sort on null array. Output: " + Arrays.toString(arr5));

		int[] arr6 = {10};
		this.mergeSort(arr6);
		System.out.println("Merge sort on {10}. Output: " + Arrays.toString(arr6));
	}

}
