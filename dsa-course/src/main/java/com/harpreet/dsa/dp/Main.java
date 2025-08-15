package com.harpreet.dsa.dp;

public class Main {

	public static void main(String[] args) {
		testKnapsack01();		
		testFibonacci();
		testKnapsackUnbounded();
		testCoinChange();
	}
	
	private static void testKnapsack01() {
		Knapsack01 knapsack01 = new Knapsack01();
		
		// knapsack()
		int maxValue = knapsack01.knapsack(50, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsack() returned max value: " + maxValue + " (expected 150)");
		
		try {
			maxValue = knapsack01.knapsack(50, null, new int[]{40, 70, 80});
		}
		catch(Exception e) {
			System.out.println("Knapsack01: knapsack() raised exception as expected." 
								+ "\n\tException: " + e.getMessage()
								+ "\n\tExpected exception: Input arrays cannot be null or empty.");
		}
		
		maxValue = knapsack01.knapsack(0, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsack() returned max value: " + maxValue + " (expected 0)");
		
		// knapsackMemo()
		maxValue = knapsack01.knapsackMemo(50, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackMemo() returned max value: " + maxValue + " (expected 150)");
		
		try {
			maxValue = knapsack01.knapsackMemo(50, null, new int[]{40, 70, 80});
		}
		catch(Exception e) {
			System.out.println("Knapsack01: knapsackMemo() raised exception as expected." 
								+ "\n\tException: " + e.getMessage()
								+ "\n\tExpected exception: Input arrays cannot be null or empty.");
		}
		
		maxValue = knapsack01.knapsackMemo(0, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackMemo() returned max value: " + maxValue + " (expected 0)");
		
		// knapsackTab()
		maxValue = knapsack01.knapsackTab(7, new int[]{3, 2, 5}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTab() returned max value: " + maxValue + " (expected 150)");
		
		maxValue = knapsack01.knapsackTab(0, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTab() returned max value: " + maxValue + " (expected 0)");
		
		try {
			maxValue = knapsack01.knapsackTab(7, new int[]{}, new int[]{});
		}
		catch(Exception e) {
			System.out.println("Knapsack01: knapsackTab() raised exception as expected." 
								+ "\n\tException: " + e.getMessage()
								+ "\n\tExpected exception: Input arrays cannot be null or empty.");
		}
		
		// knapsackTabOpt()	
		maxValue = knapsack01.knapsackTabOpt(7, new int[]{3, 2, 5}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTabOpt() returned max value: " + maxValue + " (expected 150)");
				
		try {
			maxValue = knapsack01.knapsackTabOpt(0, null, null);
		}
		catch(Exception e) {
			System.out.println("Knapsack01: knapsackTabOpt() raised exception as expected." 
								+ "\n\tException: " + e.getMessage()
								+ "\n\tExpected exception: Input arrays cannot be null or empty.");
		}	
		
		maxValue = knapsack01.knapsackTabOpt(0, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTabOpt() returned max value: " + maxValue + " (expected 0)");
		
		try {
			maxValue = knapsack01.knapsackTabOpt(-1, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		}
		catch(Exception e) {
			System.out.println("Knapsack01: knapsackTabOpt() raised exception as expected." 
					+ "\n\tException: " + e.getMessage()
					+ "\n\tExpected exception: Capacity cannot be negative.");
		}		

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
	
	private static void testKnapsackUnbounded() {		
		System.out.println();
		
		KnapsackUnbounded knapsackUnbounded = new KnapsackUnbounded();
		
		int capacity = 7;
		int[] wts = {3, 2, 5};
		int[] vals = {40, 70, 80};
		
		int maxValue = knapsackUnbounded.knapsackUnbdMemo(capacity, wts, vals);
		System.out.println("KnapsackUnbounded: knapsackUnbdMemo() returned max value: " + 
							maxValue + " (expected 210)");
		
		maxValue = knapsackUnbounded.knapsackUnbdMemo(0, wts, vals);
		System.out.println("KnapsackUnbounded: knapsackUnbdMemo() returned max value: " + 
							maxValue + " (expected 0)");
		
		try {
			maxValue = knapsackUnbounded.knapsackUnbdMemo(capacity, wts, null);
		}
		catch(Exception e) {
			System.out.println("KnapsackUnbounded: knapsackUnbdMemo() raised exception as expected." 
					+ "\n\tException: " + e.getMessage()
					+ "\n\tExpected exception: Input arrays cannot be null or empty.");
		}
		
		maxValue = knapsackUnbounded.knapsackUnbdTab(capacity, wts, vals);
		System.out.println("KnapsackUnbounded: knapsackUnbdTab() returned max value: " + 
							maxValue + " (expected 210)");		
		
		maxValue = knapsackUnbounded.knapsackUnbdTabOpt(capacity, wts, vals);
		System.out.println("KnapsackUnbounded: knapsackUnbdTabOpt() returned max value: " + 
							maxValue + " (expected 210)");		
		
		maxValue = knapsackUnbounded.knapsackUnbdTabOpt(0, wts, vals);
		System.out.println("KnapsackUnbounded: knapsackUnbdTabOpt() returned max value: " + 
							maxValue + " (expected 0)");	
		
	}
	
	private static void testCoinChange() {
		System.out.println();
			
		CoinChange coinChange = new CoinChange();
		
		// count combinations
		int targetAmt = 5; 
		int[] coins = {1, 2, 5};
		int combinations = coinChange.countCombinations(targetAmt, coins);
		System.out.println("CoinChange: countCombinations() returned " + combinations + " (expected 4)");
		
		targetAmt = 6;
		coins = new int[]{5};
		combinations = coinChange.countCombinations(targetAmt, coins);
		System.out.println("CoinChange: countCombinations() returned " + combinations + " (expected 0)");
		
		targetAmt = 0;
		coins = new int[] {1, 2, 5};
		combinations = coinChange.countCombinations(targetAmt, coins);
		System.out.println("CoinChange: countCombinations() returned " + combinations + " (expected 1)");
		
		targetAmt = 1;
		coins = new int[] {1, 2, 5};
		combinations = coinChange.countCombinations(targetAmt, coins);
		System.out.println("CoinChange: countCombinations() returned " + combinations + " (expected 1)");	
		
		try {
			coinChange.countCombinations(targetAmt, null);
		}
		catch(Exception e) {
			System.out.println("CoinChange: countCombinations() raised exception as expected." 
					+ "\n\tException: " + e.getMessage()
					+ "\n\tExpected exception: Coins array cannot be null or empty.");
		}
		
		// min coins
		// positive test case
		targetAmt = 10;
		coins = new int[]{1, 2, 5};
		int minCoins = coinChange.minCoins(targetAmt, coins);
		System.out.println("CoinChange: minCoins() returned " + minCoins + " (expected 2)");
		
		// positive test case
		targetAmt = 5;
		coins = new int[]{1, 2, 5};
		minCoins = coinChange.minCoins(targetAmt, coins);
		System.out.println("CoinChange: minCoins() returned " + minCoins + " (expected 1)");
		
		// positive test case
		targetAmt = 6;
		coins = new int[]{2, 5};
		minCoins = coinChange.minCoins(targetAmt, coins);
		System.out.println("CoinChange: minCoins() returned " + minCoins + " (expected 3)");
		
		// positive test case
		targetAmt = 7;
		coins = new int[]{2};
		minCoins = coinChange.minCoins(targetAmt, coins);
		System.out.println("CoinChange: minCoins() returned " + minCoins + " (expected -1)");
		
		// positive test case
		targetAmt = 11;
		coins = new int[]{2, 5, 10};
		minCoins = coinChange.minCoins(targetAmt, coins);
		System.out.println("CoinChange: minCoins() returned " + minCoins + " (expected 4)");
		
		// edge case
		targetAmt = 0;
		coins = new int[]{1, 2};
		minCoins = coinChange.minCoins(targetAmt, coins);
		System.out.println("CoinChange: minCoins() returned " + minCoins + " (expected 0)");
		
		// negative test case
		targetAmt = -1;
		coins = new int[]{1, 2, 5};
		try {
			minCoins = coinChange.minCoins(targetAmt, coins);
		}
		catch (Exception e) {
			System.out.println("CoinChange: minCoins() raised exception as expected." 
					+ "\n\tException: " + e.getMessage()
					+ "\n\tExpected exception: Target amount cannot be negative.");
		}
	}
}
