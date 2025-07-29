package com.harpreet.dsa.dp;

public class Fibonacci {

	// non DP (non dynamic programming) using RECURSION. 
	// n represents nth term or nth position. It starts from 0.
	// Time complexity is exponential i.e. O(2^n) which is huge, which is why we need DP.
	public int fib(int n) {		
		if(n < 0) {
			throw new IllegalArgumentException("Fibonacci position cannot be negative.");
		}
		
		return fibImpl(n);
	}
	
	// A simple and elegant recursive approach. Just delegate the task to
	// subproblems, add their results and return. The subproblems will get 
	// solved by the same recursive code. But the time complexity is O(2^n)
	// which is huge.
	private int fibImpl(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		return fibImpl(n-1) + fibImpl(n-2);
	}
	
	// Using Dynamic Programming (Memoization)
	// n represents nth term or nth position. It starts from 0.
	public int fibMemo(int n) {	
		if(n < 0) {
			throw new IllegalArgumentException("Fibonacci position cannot be negative.");
		}
		
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;		
		
		return fibMemoImpl(n, arr);
	}
	
	private int fibMemoImpl(int n, int[] arr) {
		if(n == 0 || n == 1 || arr[n] != 0) {
			return arr[n];
		}
					
		arr[n] = fibMemoImpl(n-1, arr) + fibMemoImpl(n-2, arr);
		return arr[n];
	}
	
	// Using Dynamic Programming (Tabulation)	
	// n represents nth term or nth position. It starts from 0.
	public int fibTab(int n) {		
		if(n < 0) {
			throw new IllegalArgumentException("Fibonacci position cannot be negative.");
		}
		
		if(n == 0 || n == 1) {
			return n;
		}
		
		int[] arr = new int[n+1];
		arr[0] = 0; 
		arr[1] = 1;
		
		for(int i=2; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];		
	}
	
	// Using Dynamic Programming (Tabulation with Space Optimization)	
	// n represents nth term or nth position. It starts from 0.
	public int fibTabOpt(int n) {		
		if(n < 0) {
			throw new IllegalArgumentException("Fibonacci position cannot be negative.");
		}
		
		if(n == 0 || n == 1) {
			return n;
		}
		
		int a=0, b=1; // first two fibonacci numbers
		int c=0; // current fibonacci number
		for(int i = 2; i <= n; i++) {
			c = a+b;
			a = b;
			b = c;			
		}
		
		return c;
	}
	
}
