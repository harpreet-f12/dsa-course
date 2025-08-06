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
		
		// create 2D array. Each cell of the array represents solution (i.e. min coins)
	 	// to a subproblem for a subset of coins and a target amount.
		int[][] dp = new int[coins.length+1][targetAmt+1]; 
		
		// initialize dp 
		// 1. targetAmt+1 is a large impossible value which indicates a subproblem
		// cannot be solved i.e. coins not found which can add up to that amount.
		for(int i=0; i <= coins.length; i++) {
			for(int j=0; j <= targetAmt; j++) {
				dp[i][j] = targetAmt+1; 
			}
		}
		// 2. for zero targetAmt, min coins needed are zero
		for(int i=0; i <= coins.length; i++) {
			dp[i][0] = 0;
		}
		
		for(int i=1; i <= coins.length; i++) {
			for(int j=1; j <= targetAmt; j++) {
				int coin = coins[i-1];
				if(j < coin) {	
					// exclusion case
					dp[i][j] = dp[i-1][j];
				}
				else { 
					// inclusion case
					dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coin]);
				}
			}
		}
				
		return dp[coins.length][targetAmt] != targetAmt+1 ? dp[coins.length][targetAmt] : -1;
	}	

}
