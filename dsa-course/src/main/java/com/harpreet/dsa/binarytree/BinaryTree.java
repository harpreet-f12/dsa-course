package com.harpreet.dsa.binarytree;

public class BinaryTree {

	public static void preorder(Node root) {
		if(root != null) {
			System.out.print(root.getVal() + " ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}

	public static void inorder(Node root) {
		if(root != null) {
			inorder(root.getLeft());
			System.out.print(root.getVal() + " ");
			inorder(root.getRight());
		}
	}

	public static void postorder(Node root) {
		if(root != null) {
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.print(root.getVal() + " ");			
		}
	}
	
	public static int height(Node root) {
		// Base case when root is null. In other words, when tree is empty.
		if(root == null) {
			return -1;
		}
	
		// Recursively calculate the heights of left and right subtrees
		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());
		
		// Height of the tree is 1 + maximum height of left and right subtrees
		return Math.max(leftHeight, rightHeight) + 1;
	}
		
	public static int depth(Node root, Node target) {
		return depthRec(root, target, 0); // 0 is depth of root
	}
	
	private static int depthRec(Node root, Node target, int depth) {
		// tree is empty
		if(root == null) {
			return -1;
		}
		
		// target node found
		if(target.equals(root)) {
			return depth;
		}
		
		int left = depthRec(root.getLeft(), target, depth+1);
		if(left != -1) {
			return left;
		}
		
		return depthRec(root.getRight(), target, depth+1);	
	}
	
}
