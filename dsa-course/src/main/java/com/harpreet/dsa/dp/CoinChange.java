package com.harpreet.dsa.dp;

import java.util.Arrays;

public class CoinChange {

	public int countCombinations(int targetAmt, int[] coins) {
		// invalid case
		if(targetAmt < 0) {
			throw new IllegalArgumentException("Target amount cannot be negative.");
		}
		
		// invalid case
		if(coins == null || coins.length == 0) {
			throw new IllegalArgumentException("Coins array cannot be null or empty.");
		}		
		
		// invalid case
		for(int val : coins) {
			if(val <= 0) {
				throw new IllegalArgumentException("Coin values must be positive.");
			}
		}
			
		int[][] memo = new int[coins.length+1][targetAmt+1];
		for(int[] row : memo) {
			Arrays.fill(row, -1);
		}
		
		return countCombinationsImpl(targetAmt, coins.length, coins, memo);
	}
	
	private int countCombinationsImpl(int targetAmt, int n, int[] coins, int[][] memo) {	
		// Base case: exact amount matched
		if(targetAmt == 0) {
			return 1;
		}
		
		// Base case: no coins left or amount gone negative
		if(targetAmt < 0 || n == 0) {
			return 0;
		}
		
		// Check if already computed
		if(memo[n][targetAmt] != -1) {
			return memo[n][targetAmt];
		}
		
		// Count including the nth coin
		int inclusionVal = countCombinationsImpl(targetAmt - coins[n-1], n, coins, memo);	
		
		// Count excluding the nth coin
		int exclusionVal = countCombinationsImpl(targetAmt, n-1, coins, memo);
		
		// Memoize the sum total of counts
		memo[n][targetAmt] = inclusionVal + exclusionVal;
		
		return memo[n][targetAmt];
	}
	
	
	public int minCoins(int targetAmt, int[] coins) {	
		// invalid case
		if(targetAmt < 0) {
			throw new IllegalArgumentException("Target amount cannot be negative.");
		}
		
		// invalid case
		if(coins == null || coins.length == 0) {
			throw new IllegalArgumentException("Coins array cannot be null or empty.");
		}		
		
		// invalid case
		for(int val : coins) {
			if(val <= 0) {
				throw new IllegalArgumentException("Coin values must be positive.");
			}
		}
				
		int[][] memo = new int[coins.length+1][targetAmt+1];
		for(int[] row : memo) {
			Arrays.fill(row, -1); // initialize the array with -1
		}
		
		int result = minCoinsImpl(targetAmt, coins.length, coins, memo);
	    return result == Integer.MAX_VALUE - 1 ? -1 : result; 
		
	}
	   
	private int minCoinsImpl(int targetAmt, int n, int[] coins, int[][] memo) {	
		if(targetAmt == 0) {
			return 0;
		}
		
		if(n == 0) {
			return Integer.MAX_VALUE - 1; // subtracting -1 to prevent overflow
		}
		
		if(memo[n][targetAmt] != -1) {
			return memo[n][targetAmt]; // the problem was solved earlier. Use memoized result.
		}
		
		// skip the current coin if it is greater than the targetAmt
		if(targetAmt < coins[n-1]) {
			return memo[n][targetAmt] = minCoinsImpl(targetAmt, n-1, coins, memo);
		}
		
		// include the coin
		int inclusionVal = 1 + minCoinsImpl(targetAmt - coins[n-1], n, coins, memo);
		
		// exclude the coin
		int exclusionVal = minCoinsImpl(targetAmt, n-1, coins, memo);		
				
		return memo[n][targetAmt] = Math.min(inclusionVal, exclusionVal);
	}		

}
