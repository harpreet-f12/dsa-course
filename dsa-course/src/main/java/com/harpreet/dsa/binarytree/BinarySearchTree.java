package com.harpreet.dsa.binarytree;

public class BinarySearchTree extends BinaryTree {
	private Node root;
	
	public BinarySearchTree(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}
		
		for(int val : arr) {
			insertIter(val);
		}
	}
	
	public Node getRoot() {
		return this.root;
	}
		
	public boolean search(int val) {
		return this.searchImpl(this.root, val);
	}
	
	private boolean searchImpl(Node node, int val) {
		if(node == null) {
			return false;
		}		
		
		if(val == node.getVal()) {
			return true;
		}
		else if(val < node.getVal()) {
			return this.searchImpl(node.getLeft(), val);
		}
		else {
			return this.searchImpl(node.getRight(), val);
		}
	}
		
	// insert method using iteration
	public void insertIter(int val) {
		Node node = new Node(val);
		
		if(root == null){
			root = node;
			return;
		}
		
		Node p1 = root, p2 = null;
		
		while(p1 != null) {
			if(val <= p1.getVal()) {
				p2 = p1;
				p1 = p1.getLeft();
				if(p1 == null) {
					p2.setLeft(node);
				}
			}
			else {
				p2 = p1;
				p1 = p1.getRight();
				if(p1 == null) {
					p2.setRight(node);
				}
			}
		}						
	}	
	
	// recursive variant of insert method
	public void insert(int val) {							
		root = insertRec(root, val);		
	}	
	
	private Node insertRec(Node node, int val) {
		if(node == null) {
			return new Node(val);
		}
		
		if(val <= node.getVal()) {
			Node child = insertRec(node.getLeft(), val);
			node.setLeft(child);			
		}
		else {
			Node child = insertRec(node.getRight(), val);
			node.setRight(child);
		}
		
		return node;
	}
	
}
