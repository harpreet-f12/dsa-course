package com.harpreet.dsa.dp;

import java.util.Arrays;

public class KnapsackUnbounded {

	// DP (dynamic programming) using Memoization approach
	public int knapsackUnbdMemo(int capacity, int[] wts, int[] vals) {
		if(wts == null || wts.length == 0 || vals == null || vals.length == 0) {
			return 0;
		}
		
		if(wts.length != vals.length) {
			throw new IllegalArgumentException("Lengths of weights and values array don't match");
		}
		
		int itemCount = wts.length;
		
		// create a memo table and initialize all cells to -1
		int[][] memo = new int[itemCount+1][capacity+1];		
		for(int[] row : memo) {
			Arrays.fill(row, -1);
		}
		
		return knapsackUnbdMemoImpl(capacity, itemCount, wts, vals, memo);
	}
	
	private int knapsackUnbdMemoImpl(int capacity, int itemCount, int[] wts, int[] vals, int[][] memo) {
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
	        memo[itemCount][capacity] = knapsackUnbdMemoImpl(capacity, itemCount-1, wts, vals, memo);
	    } 
	    else {
	        // Option 1: Include the current item
	        int inclusionVal = vals[itemCount - 1] + 
	        					knapsackUnbdMemoImpl(capacity-wts[itemCount-1], itemCount, 
	        											wts, vals, memo);
	        
	        // Option 2: Exclude the current item
	        int exclusionVal = knapsackUnbdMemoImpl(capacity, itemCount-1, wts, vals, memo);
	        
	        // Take the maximum of both options
	        memo[itemCount][capacity] = Math.max(inclusionVal, exclusionVal);
	    }
	
	    return memo[itemCount][capacity];
	}	
	
	// DP using Tabulation approach
	public int knapsackUnbdTab(int capacity, int[] wts, int[] vals) {
		if(capacity == 0 || wts == null || wts.length == 0 
						|| vals == null || vals.length == 0) {
			return 0;
		}
		
		if(wts.length != vals.length) {
			throw new IllegalArgumentException("Lengths of weights and values array don't match");
			}
			
			int itemCount = wts.length;
	  
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
								vals[i-1] + dp[i][j-wts[i-1]] // Include the item
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
	public int knapsackUnbdTabOpt(int capacity, int[] wts, int[] vals) {
		if(capacity == 0 || wts == null || wts.length == 0 
						|| vals == null || vals.length == 0) {
			return 0;
		}
	
		if(wts.length != vals.length) {
			throw new IllegalArgumentException("Lengths of weights and values array don't match");
		}
		
		int itemCount = wts.length;
			
		// Create a single dimensional array to store the current maximum value
		// for each capacity
		int[] dp = new int[capacity+1];
	  
		// The outer loop iterating on capacity means trying all items for a given capacity.
		// Each item can be included multiple items.
		for(int c=0; c <= capacity; c++) {
			for(int i=0; i < itemCount; i++) {
				if(wts[i] <= c) {
					dp[c] = Math.max(dp[c], vals[i] + dp[c-wts[i]]);
				}
			}
		}
		
		// The result is stored in dp[capacity]
		return dp[capacity];
	}

}


