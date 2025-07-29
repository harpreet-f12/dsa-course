package com.harpreet.dsa.dp;

public class Main {

	public static void main(String[] args) {
		testKnapsack01();		
		testFibonacci();
	}
	
	private static void testKnapsack01() {
		Knapsack01 knapsack01 = new Knapsack01();
		int maxValue = knapsack01.knapsack(50, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsack() returned max value: " + maxValue + " (expected 150)");
		
		maxValue = knapsack01.knapsack(50, null, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsack() returned max value: " + maxValue + " (expected 0)");
		
		maxValue = knapsack01.knapsackMemo(50, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackMemo() returned max value: " + maxValue + " (expected 150)");
		
		maxValue = knapsack01.knapsackMemo(50, new int[]{10, 20, 30}, null);
		System.out.println("Knapsack01: knapsackMemo() returned max value: " + maxValue + " (expected 0)");
		
		maxValue = knapsack01.knapsackTab(7, new int[]{3, 2, 5}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTab() returned max value: " + maxValue + " (expected 150)");
		
		maxValue = knapsack01.knapsackTab(0, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTab() returned max value: " + maxValue + " (expected 0)");
		
		maxValue = knapsack01.knapsackTabOpt(50, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTabOpt() returned max value: " + maxValue + " (expected 150)");
		
		maxValue = knapsack01.knapsackTabOpt(0, null, null);
		System.out.println("Knapsack01: knapsackTabOpt() returned max value: " + maxValue + " (expected 0)");		
	}
	
	private static void testFibonacci() {		
		Fibonacci fibonacci = new Fibonacci();
		
		System.out.println();
		
		// Find 0th term i.e. value at 0th position
		System.out.println("Fibonacci 0th term: " + fibonacci.fib(0) + " (expected 0)");
		
		// Find 7th term i.e. value at 7th position
		System.out.println("Fibonacci 7th term: " + fibonacci.fib(7) + " (expected 13)");
		
		// Negative test case. Find number at -1 position.
		try {
			fibonacci.fib(-1);
		}
		catch(IllegalArgumentException e) {
			System.out.println("Called fibonacci on -1 position. Exception raised as expected");
		}
		
		// Find 8th term
		System.out.println("Fibonacci 8th term: " + fibonacci.fibMemo(8) + " (expected 21)");
		
		// Find 9th term
		System.out.println("Fibonacci 9th term: " + fibonacci.fibTab(9) + " (expected 34)");
		
		// Find 10th term
		System.out.println("Fibonacci 10th term: " + fibonacci.fibTabOpt(10) + " (expected 55)");
		
		// Find 1st term
		System.out.println("Fibonacci 1st term: " + fibonacci.fibTabOpt(1) + " (expected 1)");		
	}
	
}
