package com.harpreet.dsa.graph;

public class GraphForTSP {
	
    // Graph stored as Adjacency matrix
	private int[][] adjMatrix;
	private String[] vertexLabels;
	private int vertexCount;
	
	public GraphForTSP(int vertexCount) {
		this.adjMatrix = new int[vertexCount][vertexCount]; // initial values are 0.
		this.vertexLabels = new String[vertexCount];
		this.vertexCount = vertexCount;
	}	
    
	public void addEdge(int from, int to, int weight) {
		adjMatrix[from][to] = weight;
		adjMatrix[to][from] = weight;
	}
	
	public void setVertexLabel(int vertex, String label) {
		vertexLabels[vertex] = label;
	}
	
	// Traveling Salesman Problem
	public void TSP(int srcNode) {
		boolean[] visited = new boolean[vertexCount];			
		visited[srcNode] = true;
		int totalWt = 0;
						
		// print the starting city
		System.out.print("TSP Route: " + vertexLabels[srcNode] + " -> ");
		
		int currNode = srcNode;
		for(int i = 0; i < vertexCount-1; i++) {				
			// find nearest unvisited node (i.e. nearest city) from currNode
			int minWt = Integer.MAX_VALUE; // set to infinity
			int nearestCity = -1; // invalid value						
			for(int targetNode=0; targetNode < vertexCount; targetNode++) {
				if(!visited[targetNode] && 
				   adjMatrix[currNode][targetNode] != 0 &&
				   adjMatrix[currNode][targetNode] < minWt) {
						minWt = adjMatrix[currNode][targetNode];
						nearestCity = targetNode;
				}
			}
					
			// throw an exception if nearest city not found
			if(nearestCity == -1) {
				throw new IllegalStateException("Graph is not fully connected; "
					+ "no unvisited adjacent city found from city: " + vertexLabels[currNode]);
			}			
			
			// print the nearest city and set it as the current node
			System.out.print(vertexLabels[nearestCity] + " -> ");			
			visited[nearestCity] = true;
			totalWt += minWt;
			currNode = nearestCity;
		}
		
		// return back to origin i.e. srcNode
		System.out.println(vertexLabels[srcNode]);
		totalWt += adjMatrix[currNode][srcNode];
		
		System.out.println("Total distance of route: " + totalWt);				
	}
    
}
