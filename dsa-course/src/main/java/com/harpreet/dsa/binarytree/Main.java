package com.harpreet.dsa.binarytree;

public class Main {

	public static void main(String[] args) {
		/* Binary Tree */
		testTraversals();
		testBinaryTreeHeightDepth();
		
		/* Binary Search Tree */
		testBSTCreationAndTraversals();
		testBSTInsertion();
		testBSTSearch();
		testBSTDeletion();
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
		
		System.out.println("\nLevel order traversal:");
		BinaryTree.levelOrder(root);
		
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
	
	private static void testBSTCreationAndTraversals() {
		int[] arr = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
		BinarySearchTree bst = new BinarySearchTree(arr);
		
		System.out.println("\nBST Preorder traversal:");
		BinaryTree.preorder(bst.getRoot());
		
		System.out.println("\nBST Inorder traversal:");
		BinaryTree.inorder(bst.getRoot());
		
		System.out.println("\nBST Postorder traversal:");
		BinaryTree.postorder(bst.getRoot());
		
		System.out.println("\nBST Level order traversal:");
		BinaryTree.levelOrder(bst.getRoot());
	}
	
	private static void testBSTInsertion() {
		int[] arr = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11};
		BinarySearchTree bst = new BinarySearchTree(arr);
		
		bst.insertIter(14);
		bst.insert(13);
		bst.insertIter(15);
		
		System.out.println("\n");
		System.out.println("Inorder traversal should output 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 "
																			+ "in the next line");
		BinaryTree.inorder(bst.getRoot());		
	}
	
	private static void testBSTSearch() {
		int[] arr = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11};
		BinarySearchTree bst = new BinarySearchTree(arr);
		
		System.out.println("\n");
		
		boolean ret = bst.search(6);
		System.out.println("BST search for 6 returned: " + ret + " , Expected: true");
		
		ret = bst.search(11);
		System.out.println("BST search for 11 returned: " + ret + " , Expected: true");
		
		ret = bst.search(8);
		System.out.println("BST search for 8 returned: " + ret + " , Expected: true");
		
		ret = bst.search(999);
		System.out.println("BST search for 999 returned: " + ret + " , Expected: false");		
	}
	
	private static void testBSTDeletion() {
		
	}
}
