package com.nadeem.app.dsa.adt.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NArrayTree<T> {
	
	private Node<T> root;
	
	public NArrayTree(Node<T> root) {
		this.root = root;
	}
	
	public List<T> bfs() {
		List<T> result = new ArrayList<T>();
		Deque<Node<T>> queue = new ArrayDeque<Node<T>>();
		queue.offer(this.root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();
			
			for (Node<T> child : node.getChildren()) {
				queue.offer(child);
			}
			result.add(node.getData());
		}		
		
		return result;
	}
	
	public List<T> dfs() {
		List<T> result = new ArrayList<T>();
		Deque<Node<T>> stack = new ArrayDeque<Node<T>>();
		stack.push(this.root);
		while (!stack.isEmpty()) {
			Node<T> node =  stack.pop();
			
			for (Node<T> child : node.getChildren()) {
				stack.push(child);
			}
			result.add(node.getData());
		}		
		return result;
	}

	static class Node<T> {
		 private T data;
		 private List<Node<T>> children;
		 
		 public Node(T data) {
			this.data = data;
			this.children = new ArrayList<NArrayTree.Node<T>>();
		}
		 
		public void addChild(Node<T> child) {
			this.children.add(child);
		}

		public T getData() {
			return data;
		}
		
		
		public List<Node<T>> getChildren() {
			return children;
		}

		@Override
		public String toString() {
			return String.valueOf(getData());
		}
	}

	static class TreeBuilder<T> {
	    private int idxPre, idxPost;
	    private final T[] preOrder;
	    private final T[] postOrder;
		public TreeBuilder(T[] preOrder, T[] postOrder) {
	        this.preOrder = preOrder;
	        this.postOrder = postOrder;
	    }
	    
	    public NArrayTree<T> buildTree() {
	    	return new NArrayTree<T>(doBuildTree());
	    }

	    private Node<T> doBuildTree() {
	        Node<T> root = new Node<T>(preOrder[idxPre++]);
	        while(true) {
	            if(root.data.equals(postOrder[idxPost])) {
	                idxPost++;
	                break;
	            }
	            root.addChild(doBuildTree());
	        }
	        return root;
	    }
	}

	public static void main(String[] args) {
		TreeBuilder<Integer> tb = new TreeBuilder<Integer>(new Integer[]{1,2,3,4,5,6,7,8,9}, new Integer[]{3,4,2,6,5,9,8,7,1});
		NArrayTree<Integer> tree = tb.buildTree();
		List<Integer> result = tree.bfs();
		for (int item : result) {
			System.out.println(item);
		}
	}
}
