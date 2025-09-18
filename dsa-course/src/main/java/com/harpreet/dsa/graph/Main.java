package com.harpreet.dsa.graph;

public class Main {

	public static void main(String[] args) {
		// test DFS and BFS traversals
		testTraversalsForUndirectedGraph();
		testTraversalsForDirectedGraph();
	}
	
	public static void testTraversalsForUndirectedGraph() {
		int vertexCount = 12;
		UndirectedGraph graph = new UndirectedGraph(vertexCount);
		
		graph.setVertexLabel(0, 'A');
		graph.setVertexLabel(1, 'B');
		graph.setVertexLabel(2, 'C');
		graph.setVertexLabel(3, 'D');
		graph.setVertexLabel(4, 'E');
		graph.setVertexLabel(5, 'F');
		graph.setVertexLabel(6, 'G');
		graph.setVertexLabel(7, 'H');
		graph.setVertexLabel(8, 'I');
		graph.setVertexLabel(9, 'J');
		graph.setVertexLabel(10, 'K');
		graph.setVertexLabel(11, 'L');
		
		graph.addEdge(0, 1); // A - B 
		graph.addEdge(0, 2); // A - C
		graph.addEdge(1, 2); // B - C
		graph.addEdge(1, 3); // B - D
		graph.addEdge(1, 4); // B - E
		graph.addEdge(1, 5); // B - F
		graph.addEdge(1, 6); // B - G
		graph.addEdge(3, 7); // D - H
		graph.addEdge(3, 8); // D - I
		graph.addEdge(5, 8); // F - I
		graph.addEdge(7, 9); // H - J
		graph.addEdge(8, 9); // I - J
		graph.addEdge(8, 10); // I - K
		graph.addEdge(10, 11); // K - L
		
		graph.printGraph();		
		graph.dfs(); // Expected: A B C D H J I F K L E G		
		graph.bfs(); // Expected: A B C D E F G H I J K L
		System.out.println();
	}
	
	public static void testTraversalsForDirectedGraph() {
		int vertexCount = 12;
		DirectedGraph graph = new DirectedGraph(vertexCount);
		
		graph.setVertexLabel(0, 'A');
		graph.setVertexLabel(1, 'B');
		graph.setVertexLabel(2, 'C');
		graph.setVertexLabel(3, 'D');
		graph.setVertexLabel(4, 'E');
		graph.setVertexLabel(5, 'F');
		graph.setVertexLabel(6, 'G');
		graph.setVertexLabel(7, 'H');
		graph.setVertexLabel(8, 'I');
		graph.setVertexLabel(9, 'J');
		graph.setVertexLabel(10, 'K');
		graph.setVertexLabel(11, 'L');
		
		graph.addEdge(0, 1); // A to B 
		graph.addEdge(0, 2); // A to C
		graph.addEdge(1, 3); // B to D
		graph.addEdge(1, 4); // B to E
		graph.addEdge(1, 5); // B to F
		graph.addEdge(1, 6); // B to G
		graph.addEdge(2, 1); // C to B		
		graph.addEdge(3, 7); // D to H
		graph.addEdge(3, 8); // D to I
		graph.addEdge(5, 8); // F to I
		graph.addEdge(7, 9); // H to J
		graph.addEdge(8, 10); // I to K
		graph.addEdge(9, 8); // J to I
		graph.addEdge(10, 11); // K to L
		
		graph.printGraph();		
		graph.dfs(); // Expected: A B D H J I K L E F G C		
		graph.bfs(); // Expected: A B C D E F G H I J K L
		System.out.println();
	}

}
