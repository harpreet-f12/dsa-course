package com.harpreet.dsa.dp;

public class Main {

	public static void main(String[] args) {
		testKnapsack01();		
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
		
		maxValue = knapsack01.knapsackTab(50, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTab() returned max value: " + maxValue + " (expected 150)");
		
		maxValue = knapsack01.knapsackTab(0, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTab() returned max value: " + maxValue + " (expected 0)");
		
		maxValue = knapsack01.knapsackTabOpt(50, new int[]{10, 20, 30}, new int[]{40, 70, 80});
		System.out.println("Knapsack01: knapsackTabOpt() returned max value: " + maxValue + " (expected 150)");
		
		maxValue = knapsack01.knapsackTabOpt(0, null, null);
		System.out.println("Knapsack01: knapsackTabOpt() returned max value: " + maxValue + " (expected 0)");		
	}
}
