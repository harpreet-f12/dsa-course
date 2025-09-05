package com.harpreet.dsa.binarysearch;

public class BinarySearch {

	// return value is the index at which element was found or -1 if not found
	public int binarySearch(int[] arr, int target, int left, int right) {
		if(left <= right) {
			int middle = (left + right)/2;
	
			if(arr[middle] == target) {
				return middle;
			}
			else if(target < arr[middle]) {
				return binarySearch(arr, target, left, middle-1);
			}
			else {
				return binarySearch(arr, target, middle+1, right);
			}
		}
	
		return -1;
	}
	
}
