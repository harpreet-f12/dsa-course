package com.harpreet.dsa.graph;

//Graph class to try Union-Find algo
public class GraphForUnionFind {

	int[][] edgeList; // undirected graph
	char[] vertexLabels;
	int vertexCount;
	
	public GraphForUnionFind(int[][] edgeList, int vertexCount){
		this.edgeList = edgeList;		
		this.vertexLabels = new char[vertexCount]; 
		this.vertexCount = vertexCount;
	}
	

	public boolean hasCycle() {
		int[] parents = new int[vertexCount];
		
		// each node is it's own parent initially
		for(int i=0; i < vertexCount; i++) {
			parents[i] = i;
		}
		
		for(int[] edge : edgeList) {
			int u = edge[0], v = edge[1];
			int rootU = find(u, parents);
			int rootV = find(v, parents);
			
			if(rootU == rootV) {
				// cycle exists
				return true;
			}
			
			// union
			parents[rootU] = rootV;	
		}
		
		return false;
	}
	
	private int find(int vertex, int[] parents) {
		if(parents[vertex] == vertex) {
			return vertex;
		}
		
		// path compression to optimize future find
		return parents[vertex] = find(parents[vertex], parents);
	}	

}
