package com.harpreet.dsa;

public class Main {

	public static void main(String[] args) {
		
		/* Bubble Sort */
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.demoBubbleSort();		
		
		/* Insertion Sort */
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.demoInsertionSort();
		
		/* Selection Sort */
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.demoSelectionSort();
		
		/* Merge Sort */
		MergeSort mergeSort = new MergeSort();
		mergeSort.demoMergeSort();
		
		/* Quick Sort */
		QuickSort quickSort = new QuickSort();
		quickSort.demoQuickSort();
		
		/* Heap Sort */
		HeapSort heapSort = new HeapSort();
		heapSort.demoHeapSort();
		
		/* Counting Sort */
		CountingSort countingSort = new CountingSort();
		countingSort.demoCountingSort();
	}

}
