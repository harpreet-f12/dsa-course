package com.harpreet.dsa.graph;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

//Graph class for trying Dijkstra's algo
public class GraphForDijkstra {
	
	// Edge class representing weighted edge
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    
    // Graph stored as Adjacency list
	private List<List<Edge>> adjList;
	private char[] vertexLabels;
	
	public GraphForDijkstra(int vertexCount) {
		adjList = new ArrayList<>(vertexCount);
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

	// Dijkstra implementation without using Priority Queue
	public void dijkstraWithoutPQ(int startNode) {
        int vertexCount = adjList.size();
        
        // distances array records the distance of each node from starting node
        int[] distances = new int[vertexCount];
        Arrays.fill(distances, Integer.MAX_VALUE); // initialized with infinity
        distances[startNode] = 0; // distance of starting node to itself is zero

        // visited[] records visited statuses of nodes. Default values are false
        boolean[] visited = new boolean[vertexCount];
        
        // while loop continues until all nodes are visited or are unreachable
        while(true) {        	
	    	// find nearest unvisited node. In first iteration, it would be the
	    	// the startNode itself.
			int nearest = -1;
			int minDistance = Integer.MAX_VALUE;
			for(int i=0; i < vertexCount; i++) {
				if(!visited[i] && distances[i] < minDistance) {
					nearest = i;
					minDistance = distances[i];
				}
			}
			       
			// break when there is no node left to visit. Either all nodes have been
			// visited or nodes are unreachable.
			if(nearest == -1) {
				break;
			}
						
	        visited[nearest] = true;
	        
	        // relax all edges from nearest node
	        for(Edge edge : adjList.get(nearest)) {
	        	int v = edge.target;
	        	int wt = edge.weight;
	        	if(!visited[v]) {
	        		if(distances[v] > distances[nearest] + wt) {
	        			distances[v] = distances[nearest] + wt;
	        		}
	        	}
	        }
        }
                        
        // print distances
        for(int v=0; v < vertexCount; v++) {
        	String distance = (distances[v] == Integer.MAX_VALUE) ? 
        							"Unreachable" : String.valueOf(distances[v]);
        	System.out.println(vertexLabels[startNode] + "\t" + vertexLabels[v] + 
        							"\t" + distance);
        }
	}
	
	// Node class required for storage in PriorityQueue
	// Objects are compared on the basis of their distance from start node.
	static class Node implements Comparable<Node> {
	    int vertex;
	    int distance;
	
	    Node(int vertex, int distance) {
	        this.vertex = vertex;
	        this.distance = distance;
	    }
	
	    @Override
	    public int compareTo(Node other) {
	        return Integer.compare(this.distance, other.distance);
	    }
	}
	
	// Dijkstra implementation using Priority Queue
	public void dijkstra(int startNode) {
	    int vertexCount = adjList.size();
	    
	    // distances array records the distance of each node from source node
	    int[] distances = new int[vertexCount];
	    Arrays.fill(distances, Integer.MAX_VALUE); // array elements initialized with infinity
	    distances[startNode] = 0; // distance of source node to itself is zero
	
	    // visited[] records visited statuses of nodes. Default values are false
	    boolean[] visited = new boolean[vertexCount];
	    
	    // PriorityQueue helps searching nearest node faster
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.offer(new Node(startNode, 0)); // initialize with start node and distance zero
	
	    while (!pq.isEmpty()) {
	        Node node = pq.poll(); // retrieves the nearest node.
	        int nearest = node.vertex;
	
	        if (visited[nearest]) continue;
	        
	        visited[nearest] = true;
	
	        // relax all edges from current node
	        for (Edge edge : adjList.get(nearest)) {
	            int v = edge.target;
	            int weight = edge.weight;
	            if (!visited[v] && distances[v] > distances[nearest] + weight) {
	                distances[v] = distances[nearest] + weight;
	                pq.offer(new Node(v, distances[v])); // add node
	            }
	        }
	    }
	
	    // print distances
	    for(int dest=0; dest < vertexCount; dest++) {
	    	String distance = (distances[dest] == Integer.MAX_VALUE) ? 
	    							"Unreachable" : String.valueOf(distances[dest]);
	    	System.out.println(vertexLabels[startNode] + "\t" + vertexLabels[dest] + 
	    							"\t" + distance);
	    }
	}
}
