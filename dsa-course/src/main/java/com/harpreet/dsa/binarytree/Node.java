package com.harpreet.dsa.binarytree;

// Class representing node of a Binary Tree and Binary Search Tree.
public class Node {
	private int val;
	private Node left;
	private Node right;

	public Node(int val) {
		this.val = val;
	}

	public int getVal() {
		return this.val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
		
	public Node getLeft() {
		return this.left;
	}
	
	public void setLeft(Node node) {
		this.left = node;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public void setRight(Node node) {
		this.right = node;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return val == other.val;
	}				
}