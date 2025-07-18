package com.harpreet.dsa.sorting;

import java.util.Arrays;

public class HeapSort {

	public void heapSort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}

		// Step 1: convert array into max Heap
		// elements from len/2 index and onwards are leaf nodes which don’t have any children
		int len = arr.length;
		for(int i = len/2-1; i >= 0; i-- ) {
			maxHeapify(arr, i, len);
		}

		// Step 2: swap first element which is the largest element with the last one and run
		// maxHeapify on first element
		while(len > 1) {
			int tmp = arr[0];
			arr[0] = arr[len-1];
			arr[len-1] = tmp;

			// Reduce the length of array by 1 and run maxHeapify again
			len -= 1;
			maxHeapify(arr, 0, len);
		}

	}

	private void maxHeapify(int[] arr, int index, int length) {
		int max = index;
		
		while(true) {
			int lChild = index * 2 + 1; // left child
			int rChild = index * 2 + 2; // right child
			
			// find the largest amongst parent and left, right children
			// and swap the parent with the largest 
			if(lChild < length && arr[max] < arr[lChild]) {
				max = lChild;
			}
			if(rChild < length && arr[max] < arr[rChild]) {
				max = rChild;
			}
			
			if(max != index) {
				int tmp = arr[index];
				arr[index] = arr[max];
				arr[max] = tmp;
	
				index = max;
			}
			else {
				// heap property is satisfied
				break;
			}
		}
	}

	public void demoHeapSort() {
		// array of odd length
		int[] arr = {10, 5, 20, 6, 30, 7, 40};
		this.heapSort(arr);
		System.out.println("Heap sort on {10, 5, 20, 6, 30, 7, 40}. Output: " + Arrays.toString(arr));

		// array of even length
		int[] arr2 = {10, 50, 20, 80, 30, 40};
		this.heapSort(arr2);
		System.out.println("Heap sort on {10, 50, 20, 80, 30, 40}. Output: " + Arrays.toString(arr2));

		// empty array
		int[] arr3 = {};
		this.heapSort(arr3);
		System.out.println("Heap sort on {}. Output: " + Arrays.toString(arr3));

		// null array
		int[] arr4 = null;
		this.heapSort(arr4);
		System.out.println("Heap sort on null array. Output: " + Arrays.toString(arr4));
	}

}
