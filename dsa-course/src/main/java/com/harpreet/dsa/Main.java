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

	}

}
