package com.harpreet.dsa.graph;

public class Main {

	public static void main(String[] args) {
		// test DFS and BFS traversals
		testTraversalsForUndirectedGraph();
		testTraversalsForDirectedGraph();
		
		// test Dijkstra
		testDijkstra();
		
		// test Prim's MST
		testPrimMST();
		
		// test TSP
		testTSP();
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

	public static void testDijkstra() {
		System.out.println("Testing Dijkstra");
		
        GraphForDijkstra graph = new GraphForDijkstra(7);
        graph.setVertexLabel(0, 'A');
        graph.setVertexLabel(1, 'B');
        graph.setVertexLabel(2, 'C');
        graph.setVertexLabel(3, 'D');
        graph.setVertexLabel(4, 'E');
        graph.setVertexLabel(5, 'F');
        graph.setVertexLabel(6, 'G');
        
	    graph.addEdge(0, 1, 4); // between A and B
	    graph.addEdge(0, 2, 2); // between A and C
	    graph.addEdge(0, 3, 5); // between A and D
	    graph.addEdge(1, 2, 1); // between B and C 
	    graph.addEdge(1, 4, 3); // between B and E 
	    graph.addEdge(2, 4, 3); // between C and E 
	    graph.addEdge(3, 5, 7); // between D and F 
	    graph.addEdge(4, 5, 5); // between E and F  
      
        int startNode = 0;             
        graph.dijkstraWithoutPQ(startNode); 
        graph.dijkstra(startNode);
	}
	
	public static void testPrimMST() {
		int vertexCount = 6;
        GraphForPrimMST graph = new GraphForPrimMST(vertexCount);
        
        graph.addVertexLabel(0, 'A');
        graph.addVertexLabel(1, 'B');
        graph.addVertexLabel(2, 'C');
        graph.addVertexLabel(3, 'D');
        graph.addVertexLabel(4, 'E');
        graph.addVertexLabel(5, 'F');
        
        graph.addEdge(0, 1, 4);	// A - B
        graph.addEdge(0, 2, 2);	// A - C
        graph.addEdge(0, 3, 5);	// A - D
        graph.addEdge(1, 2, 1);	// B - C 
        graph.addEdge(1, 4, 3);	// B - E
        graph.addEdge(2, 4, 3);	// C - E
        graph.addEdge(3, 5, 7);	// D - F
        graph.addEdge(4, 5, 5);	// E - F        
      
        int startNode = 0;
        graph.primMST(startNode);   
        
        /* Expected output 
         * 	A to C
			C to B
			C to E
			E to F
			A to D
			Total weight: 16
         */
	}
	
	public static void testTSP() {
		/* Input graph:
		 * 	[ 0, 10, 15, 20 ]
			[ 10, 0, 35, 25 ]
			[ 15, 35, 0, 30 ]
			[ 20, 25, 30, 0 ]
		 *
		 * Expected shortest route: City A -> City B -> City D -> City C -> City A
		 * Route distance: 10+25+30+15 = 80
		 */
		int vertexCount = 4;
	    GraphForTSP graph = new GraphForTSP(vertexCount);
	    graph.setVertexLabel(0, "City A");
	    graph.setVertexLabel(1, "City B");
	    graph.setVertexLabel(2, "City C");
	    graph.setVertexLabel(3, "City D");
	    
	    graph.addEdge(0, 1, 10);	// A - B
	    graph.addEdge(0, 2, 15);	// A - C
	    graph.addEdge(0, 3, 20);	// A - D
	    graph.addEdge(1, 2, 35);	// B - C 
	    graph.addEdge(1, 3, 25);	// B - D
	    graph.addEdge(2, 3, 30);	// C - D   
	  
	    int srcNode = 0;
	    graph.TSP(srcNode);    
	}
}
