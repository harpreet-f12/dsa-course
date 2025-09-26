package com.harpreet.dsa.graph;

import java.util.Queue;
import java.util.LinkedList;

public class UndirectedGraph {
	char[] vertexLabels;
	int[][] adjMatrix;
	int vertexCount;
	
	public UndirectedGraph(int vertexCount) {
		if(vertexCount <= 0) {
			throw new IllegalArgumentException("Invalid vertex count");
		}
		
		vertexLabels = new char[vertexCount];
		adjMatrix = new int[vertexCount][vertexCount];
		this.vertexCount = vertexCount;
	}
	
	public void printGraph() {	
		System.out.println();
		
		// print vertex labels
		for(char vertex : vertexLabels) {
			System.out.print(vertex + " ");
		}
		System.out.println();
		
		// print the matrix
		// row count, col count and vertex count, all are same
		for(int row=0; row < vertexCount; row++) {
			for(int col=0; col < vertexCount; col++) {
				System.out.print(adjMatrix[row][col] + " ");	
			}
			System.out.println();
		}		
	}
	
	public void setVertexLabel(int pos, char name) {
		if(pos < 0 || pos >= vertexCount) {
			throw new IllegalArgumentException("Invalid pos");
		}
		
		vertexLabels[pos] = name;		
	}
	
	public void addEdge(int from, int to) {
		// In an undirected graph, edge can be traversed both ways, from->to and to->from.
		// In an unweighted graph, the default weight is 1.		
		adjMatrix[from][to] = 1;
		adjMatrix[to][from] = 1;
	}
	
	public void addEdge(int from, int to, int weight) {
		// In an undirected graph, edge can be traversed both ways, from->to and to->from.
		adjMatrix[from][to] = weight;
		adjMatrix[to][from] = weight;
	}
	
	// dfs where no starting vertex is specified.
	public void dfs() {
		dfs(0); // we choose to start from first vertex
	}
	
	// dfs where starting vertex is specified
	public void dfs(int vertex) {
		System.out.println("\nDFS traversal");	
		
		if(vertex < 0 || vertex >= vertexCount) {
			throw new IllegalArgumentException("Invalid input");
		}
					
		boolean visited[] = new boolean[vertexCount];		
		dfsImpl(vertex, visited);		
	}
	
	private void dfsImpl(int v1, boolean[] visited) {
		// Just like in the case of binary trees, DFS utilizes recursion		
		// print the vertex and mark it as visited
		System.out.print(vertexLabels[v1] + " ");
		visited[v1] = true;
		
		// traverse next adjacent edge through recursion
		for(int v2=0; v2 < vertexCount; v2++ ) {
			if(adjMatrix[v1][v2] != 0 && !visited[v2]) {
				dfsImpl(v2, visited);
			}
		}
	}
	
	public void bfs() {
		bfs(0); // start from 0th vertex
	}
	
	// start bfs from a chosen vertex
	public void bfs(int v) {
		System.out.println("\nBFS traversal");
		
		if(v < 0 || v >= vertexCount) {
			throw new IllegalArgumentException("Invalid input");
		}
		
		// Just like in case of binary trees, BFS utilizes a queue and iteration										
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[vertexCount];
		
		queue.add(v);
		visited[v] = true;
		System.out.print(vertexLabels[v] + " ");
		
		while(!queue.isEmpty()) {
			int i = queue.poll();
			
			// traverse all adjacent vertices which are unvisited
			for(int j=0; j < vertexCount; j++) {
				if(adjMatrix[i][j] != 0 && !visited[j]) {
					queue.add(j);
					visited[j] = true;
					System.out.print(vertexLabels[j] + " ");
				}
			}
		}
	}	
	
	public boolean hasCycleUsingDFS() {
		System.out.println("\nChecking if cycle exists in graph...");
		
		int startVertex = 0;
		int parentVertex = -1;
		boolean visited[] = new boolean[vertexCount];
		
		return hasCycleUsingDFS(startVertex, parentVertex, visited);
	}
	
	private boolean hasCycleUsingDFS(int v1, int parent, boolean[] visited) { 
		System.out.print(vertexLabels[v1] + " ");
		
		visited[v1] = true;
		
		for(int v2=0; v2 < vertexCount; v2++ ) {
			if(adjMatrix[v1][v2] != 0) {
				if(!visited[v2]) {
					if(hasCycleUsingDFS(v2, v1, visited)) {
						return true;
					}
				}
				else if(v2 != parent) {
					// Cycle found. Return from here.
					System.out.println(vertexLabels[v2]);
					System.out.println("Cycle found");
					return true;
				}
			}
		}
		
		return false;
	}
	
}
