package com.harpreet.dsa.dp;

import java.util.Arrays;

public class Knapsack01 {

	// non-DP recursive approach
	public int knapsack(int capacity, int[] wts, int[] vals) {		
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be negative");
		}

		if (wts == null || wts.length == 0 || vals == null || vals.length == 0) {
			throw new IllegalArgumentException("Input arrays cannot be null or empty.");
		}

		if (wts.length != vals.length) {
			throw new IllegalArgumentException("Lengths of weights and values arrays should match");
		}

		int itemCount = wts.length;
		
		for(int i=0; i < itemCount; i++) {
			if (wts[i] <= 0) {
				throw new IllegalArgumentException("Weights must be positive");
			}
			
			if (vals[i] <= 0) {
				throw new IllegalArgumentException("Values must be positive");
			}
		}
				
		return knapsackImpl(capacity, itemCount, wts, vals);
	}
	
	private int knapsackImpl(int capacity, int itemCount, int[] wts, int[] vals) {	
		if(itemCount == 0 || capacity == 0) {
			return 0;
		}
		
		if(wts[itemCount-1] > capacity) {
			return knapsackImpl(capacity, itemCount-1, wts, vals);
		}
	
		int inclusionVal = vals[itemCount-1] +	
					 	knapsackImpl(capacity-wts[itemCount-1], itemCount-1, wts, vals);
		
		int exclusionVal = knapsackImpl(capacity, itemCount-1, wts, vals);	
		
		return Math.max(inclusionVal, exclusionVal);				
	}
	
	
	// DP (dynamic programming) using Memoization approach
	public int knapsackMemo(int capacity, int[] wts, int[] vals) {
		// invalid case
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be negative");
		}
	
		// invalid case
		if (wts == null || wts.length == 0 || vals == null || vals.length == 0) {
			throw new IllegalArgumentException("Input arrays cannot be null or empty.");
		}
	
		// invalid case
		if (wts.length != vals.length) {
			throw new IllegalArgumentException("Lengths of weights and values arrays should match");
		}
	
		int itemCount = wts.length;
		
		for(int i=0; i < itemCount; i++) {
			if (wts[i] <= 0) {
				throw new IllegalArgumentException("Weights must be positive");
			}
			
			if (vals[i] <= 0) {
				throw new IllegalArgumentException("Values must be positive");
			}
		}
		
		// create a memo table and initialize all cells to -1
		int[][] memo = new int[itemCount+1][capacity+1];		
		for(int[] row : memo) {
			Arrays.fill(row, -1);
		}
		
		return knapsackMemoImpl(capacity, itemCount, wts, vals, memo);
	}
	
	private int knapsackMemoImpl(int capacity, int itemCount, int[] wts, int[] vals, int[][] memo) {
	    // Base case: No items or capacity left
		if(itemCount == 0 || capacity == 0) {
			return 0;
		}
	
	    // Check if the result for this subproblem is already computed
	    if (memo[itemCount][capacity] != -1) {
	        return memo[itemCount][capacity];
	    }
	
	    // If the current item's weight is more than the remaining capacity, skip it
	    if (wts[itemCount-1] > capacity) {
	        memo[itemCount][capacity] = knapsackMemoImpl(capacity, itemCount-1, wts, vals, memo);
	    } 
	    else {
	        // Option 1: Include the current item
	        int inclusionVal = vals[itemCount - 1] + 
	        		knapsackMemoImpl(capacity-wts[itemCount-1], itemCount-1, wts, vals, memo);
	        
	        // Option 2: Exclude the current item
	        int exclusionVal = knapsackMemoImpl(capacity, itemCount-1, wts, vals, memo);
	        
	        // Take the maximum of both options
	        memo[itemCount][capacity] = Math.max(inclusionVal, exclusionVal);
	    }
	
	    return memo[itemCount][capacity];
	}	
	
	
	// DP using Tabulation approach
	public int knapsackTab(int capacity, int[] wts, int[] vals) {
		// invalid case
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be negative");
		}

		// invalid case
		if (wts == null || wts.length == 0 || vals == null || vals.length == 0) {
			throw new IllegalArgumentException("Input arrays cannot be null or empty.");
		}

		// invalid case
		if (wts.length != vals.length) {
			throw new IllegalArgumentException("Lengths of weights and values arrays should match");
		}

		int itemCount = wts.length;
		
		for(int i=0; i < itemCount; i++) {
			if (wts[i] <= 0) {
				throw new IllegalArgumentException("Weights must be positive");
			}
			
			if (vals[i] <= 0) {
				throw new IllegalArgumentException("Values must be positive");
			}
		}
		
		if(capacity == 0) {
			return 0;
		}
		  
		// dp[i][j] represents the maximum value that can be obtained with
		// the first 'i' items and a capacity of 'j'. In Java, array gets 
		// initialized to zero by default.
		int[][] dp = new int[itemCount+1][capacity+1];
	
		// Build the dp table in a bottom-up manner
		for (int i = 1; i <= itemCount; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (wts[i-1] <= j) {
					// Item can be included
					dp[i][j] = Math.max(
								dp[i-1][j], // Exclude the item
								vals[i-1] + dp[i-1][j-wts[i-1]] // Include the item
								);
				} else {
					// Item cannot be included
					dp[i][j] = dp[i-1][j];
				}
			}
		}
	
		// The final result is stored in dp[itemCount][capacity]
		return dp[itemCount][capacity];
	}
	
	// DP using Tabulation with Space Optimization approach
	public int knapsackTabOpt(int capacity, int[] wts, int[] vals) {
		// invalid case
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be negative");
		}

		// invalid case
		if (wts == null || wts.length == 0 || vals == null || vals.length == 0) {
			throw new IllegalArgumentException("Input arrays cannot be null or empty.");
		}

		// invalid case
		if (wts.length != vals.length) {
			throw new IllegalArgumentException("Lengths of weights and values arrays should match");
		}

		int itemCount = wts.length;
		
		for(int i=0; i < itemCount; i++) {
			if (wts[i] <= 0) {
				throw new IllegalArgumentException("Weights must be positive");
			}
			
			if (vals[i] <= 0) {
				throw new IllegalArgumentException("Values must be positive");
			}
		}
		
		if(capacity == 0) {
			return 0;
		}
		
		// Create a single dimensional array to store the current maximum value
		// for each capacity
		int[] dp = new int[capacity+1];
	  
		for (int i = 0; i < itemCount; i++) {
			// Traverse capacities in reverse for correctness of result
			for (int j = capacity; j >= wts[i]; j--) {
				dp[j] = Math.max(dp[j], vals[i] + dp[j-wts[i]]);
			}
		}
		
		// The result is stored in dp[capacity]
		return dp[capacity];
	}

}
