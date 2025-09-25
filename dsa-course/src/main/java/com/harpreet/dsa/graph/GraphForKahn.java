package com.harpreet.dsa.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GraphForKahn {
	List<List<Integer>> adjList;
	char[] vertexLabels;
	
	public GraphForKahn(int vertexCount){
		this.adjList = new ArrayList<>(vertexCount);
		for(int i=0; i < vertexCount; i++) {
			this.adjList.add(new ArrayList<>());
		}
		
		this.vertexLabels = new char[vertexCount]; 
	}
	
	public void addEdge(int from, int to) {
		adjList.get(from).add(to);
	}
	
	public void setVertexLabel(int vertex, char label) {
		vertexLabels[vertex] = label;
	}
	
	public void kahnTopologicalSort() {
		// queue to store nodes/vertices with no incoming edges.
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// list of sorted vertices which is the output of this algorithm
		List<Integer> sortedVertices = new ArrayList<Integer>();
		
		// find incoming edges for each vertex
		int vertexCount = adjList.size();
		int[] indegree = new int[vertexCount]; // default initialization is 0.		
		for(int u=0; u < vertexCount; u++) {
			for(int v : adjList.get(u)) {
				indegree[v]++;
			}			
		}		
		
		// add vertices with zero incoming edges to the queue. These
		// become starting nodes - ones we can start from.
		for(int i=0; i < vertexCount; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		// retrieve a vertex u from queue. Put it in sortedVertices.
		// Find all outgoing edges from this vertex and remove edge to 
		// each connected vertex v. If v is left with no incoming edge, 
		// add it to the queue. Repeat until queue is empty.
		while(!queue.isEmpty()) {
			int u = queue.poll();
			sortedVertices.add(u); // marks the dependency u as satisfied
			
			for(int v : adjList.get(u)) {
				// remove the edge u->v, not in the graph structure but by
				// reducing the indegree.
				indegree[v]--;
				if(indegree[v] == 0) {
					queue.offer(v);
				}
			}					
		}
		
		if(sortedVertices.size() != vertexCount) {
			throw new RuntimeException("Graph contains a cycle. It can't "
										+ "be sorted. It must be a DAG");
		}
		
		// print sortedVertices which is the topological order
		System.out.println("Topological order using Kahn's: ");
		for(Integer i : sortedVertices) {
			System.out.print(vertexLabels[i] + " ");
		}		
	}	
	
}
