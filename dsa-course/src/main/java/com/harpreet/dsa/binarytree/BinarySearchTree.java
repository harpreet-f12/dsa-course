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
	
	public void delete(int val) {
		this.root = deleteRec(this.root, val);
	}
	
	private Node deleteRec(Node node, int val) {
		if(node == null) {
			return null;
		}
		
		if(val < node.getVal()) {
			Node child = deleteRec(node.getLeft(), val);
			node.setLeft(child);
		}
		else if (val > node.getVal()) {
			Node child = deleteRec(node.getRight(), val);
			node.setRight(child);
		}
		else { 
			// target node found
			
			// case: target node is a leaf node
			if(node.getLeft() == null && node.getRight() == null) {				
				return null;
			}
			
			// case: target node has one child
			else if (node.getLeft() == null || node.getRight() == null) {				
				return node.getLeft() != null ? node.getLeft() : node.getRight();
			}
			
			// case: target node has two children
			else {
				// find successor node				
				Node successor = node.getRight();
				while(successor.getLeft() != null) {
					successor = successor.getLeft();
				}								
				
				// update node's value to that of successor's
				node.setVal(successor.getVal());
				
				// delete successor node
				Node child = deleteRec(node.getRight(), successor.getVal());
				node.setRight(child);
				
				return node;
			}
		}
		
		return node;
	}
	
	// find minimum value. Input can be root of the tree or a subtree.
	public int getMin(Node node) {
		Node retNode = getMinNode(node);
		
		if(retNode == null) {
			throw new IllegalArgumentException("Tree is empty, cannot get minimum value.");
		}
		
		return retNode.getVal();		
	}
	
	// find node with minimum value. Input can be root of 
	// the tree or a subtree.
	public Node getMinNode(Node node) {
		if(node == null) {
			return null;
		}
		
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		
		return node;
	}
	
	// find maximum value. Input can be root of the tree or a subtree
	public int getMax(Node node) {
		Node retNode = getMaxNode(node);
		
		if(retNode == null) {
			throw new IllegalArgumentException("Tree is empty, cannot get maximum value.");
		}
		
		return retNode.getVal();		
	}
	
	// find node with maximum value. Input can be root of 
	// the tree or a subtree
	public Node getMaxNode(Node node) {
		if(node == null) {
			return null;
		}
		
		while(node.getRight() != null) {
			node = node.getRight();
		}
		
		return node;
	}	
	
	// find inorder successor. 
	public Node getSuccessor(Node node) {
		if(node == null) {
			return null;
		}
		
		// if right subtree exists, return the minimum node from the right subtree
		if(node.getRight() != null) {
			return getMinNode(node.getRight());
		}		
		// else successor will be found in the parent hierarchy - move up in the
		// tree until a node is found which is left of it's parent.
		else {
			Node p2 = null;
			Node p1 = root;
			while(p1 != null) {
				if(node.getVal() < p1.getVal()) {
					p2 = p1;
					p1 = p1.getLeft();
				}
				else if(node.getVal() > p1.getVal()) {
					p1 = p1.getRight();
				}
				else {
					break;
				}
			}			
			return p2;
		}		
	}
	
	// find inorder predecessor
	public Node getPredecessor(Node node) {
		if(node == null) {
			return null;
		}
		
		// if left subtree exists, return the maximum node from the left subtree
		if(node.getLeft() != null) {
			return getMaxNode(node.getLeft());
		}		
		// else predecessor will be found in the parent hierarchy - move up in the
		// tree until a node is found which is right of it's parent.
		else {
			Node p2 = null;
			Node p1 = root;
			while(p1 != null) {
				if(node.getVal() < p1.getVal()) {					
					p1 = p1.getLeft();
				}
				else if(node.getVal() > p1.getVal()){
					p2 = p1;
					p1 = p1.getRight();
				}
				else {
					break;
				}
			}				
			return p2;
		}				
	}	
	
}
