package com.harpreet.dsa.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class GraphForPrimMST {
	
	// Edge class representing weighted edge
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    
    // Node class used in PriorityQueue.
    // Node objects are compared based on weights.
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;
        int parent;

        Node(int vertex, int weight, int parent) {
            this.vertex = vertex;
            this.weight = weight;
            this.parent = parent;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
	
    // Graph stored as Adjacency list
	private List<List<Edge>> adjList;
	private char[] vertexLabels;
	
	public GraphForPrimMST(int vertexCount) {
		adjList = new ArrayList<>();
		for(int i = 0; i < vertexCount; i++) {
			adjList.add(new ArrayList<>());
		}
		
		vertexLabels = new char[vertexCount];
	}	
    
	public void addEdge(int from, int to, int weight) {
		adjList.get(from).add(new Edge(to, weight));
		adjList.get(to).add(new Edge(from, weight));
	}
	
	public void setVertexLabel(int vertex, char label) {
		vertexLabels[vertex] = label;
	}

	// startNode is the starting vertex for the algorithm
	public void primMST(int startNode) {				
		// If your language doesn't support LinkedHashSet functionality, use
		// any kind of set. The end result would be same, but edges won't print
		// in order.
		Set<Integer> mst = new LinkedHashSet<Integer>();
		
		int vertexCount = adjList.size();
		int[] parents = new int[vertexCount];
		Arrays.fill(parents, -1);		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();		
		pq.add(new Node(startNode, 0, -1));
		
		int totalWt = 0;
		
		while(!pq.isEmpty()) {
			// get the nearest node
			Node node = pq.poll();
			
			if(mst.contains(node.vertex)) {
				continue;
			}
			
			mst.add(node.vertex);
			totalWt += node.weight;
			parents[node.vertex] = node.parent;
			
			// check all outgoing edges
			for(Edge edge : adjList.get(node.vertex)) { 
				if(!mst.contains(edge.target)) {
					pq.offer(new Node(edge.target, edge.weight, node.vertex));
				}
			}			
		}
		
		// print out the edges of MST
		System.out.println("Edges in MST:");
		Iterator<Integer> iter = mst.iterator();
		while(iter.hasNext()) {
			int vertex = iter.next();
			int parent = parents[vertex];
			if(parent != -1) {
				System.out.println(vertexLabels[parent] + " to " + vertexLabels[vertex]);
			}
		}
		
		// print out total weight of edges
		System.out.println("Total weight: " + totalWt);
	}

}
