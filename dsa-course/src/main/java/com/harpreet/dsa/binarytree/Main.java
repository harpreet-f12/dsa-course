package com.harpreet.dsa.binarytree;

public class Main {

	public static void main(String[] args) {
		testTraversals();
		testBinaryTreeHeightDepth();
	}
	
	private static void testTraversals() {
		// construct a binary tree with this visual representation
		// 		   10
		//	     /	  \
		//	    20	  30
		//	   /  \
		//    40  50
		//			\
		//			70
		
		Node root = new Node(10);
		Node node20 = new Node(20); 
		Node node30 = new Node(30);	
		root.setLeft(node20);
		root.setRight(node30);
		Node node40 = new Node(40); 
		Node node50 = new Node(50);
		node20.setLeft(node40);
		node20.setRight(node50);
		Node node70 = new Node(70);
		node50.setRight(node70);
		
		System.out.println("\nPreorder traversal:");
		BinaryTree.preorder(root);
		
		System.out.println("\nInorder traversal:");
		BinaryTree.inorder(root);
		
		System.out.println("\nPostorder traversal:");
		BinaryTree.postorder(root);
		
		System.out.println("\n");
	}
	
	private static void testBinaryTreeHeightDepth() {
		// construct a binary tree with this visual representation
		// 		   10
		//	     /	  \
		//	    20	  30
		//	   /  \
		//    40  50
		
		Node root = new Node(10);
		Node node20 = new Node(20); 
		Node node30 = new Node(30);	
		root.setLeft(node20);
		root.setRight(node30);
		Node node40 = new Node(40); 
		Node node50 = new Node(50);
		node20.setLeft(node40);
		node20.setRight(node50);		
						
		// Following statement should print 2
		System.out.println("Height of the tree: " + BinaryTree.height(root));
		
		// Following statement should print 2
		System.out.println("Depth of the node 50: " + BinaryTree.depth(root, node50));
		
		// Negative test case. Create a node not attached to the tree. 
		// Finding it's depth should return -1
		Node node60 = new Node(60); 
		System.out.println("Depth of the node 60: " + BinaryTree.depth(root, node60));
	}
	
}
