package com.nadeem.app.dsa.algo;

import java.io.PrintStream;

import com.nadeem.app.dsa.support.BinaryTreeNode;

public class BinarySearchTree <T extends Comparable<? super T>> {
	
	private BinaryTreeNode<T> root;

	private BinarySearchTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public static <U extends Comparable<? super U>> BinarySearchTree<U> fromPostOrder(U[] seed) {
		return new BinarySearchTree<U>(doConstruct(seed, 0, seed.length - 1));
	}

	private static<U extends Comparable<? super U>> BinaryTreeNode<U> doConstruct(U[] seed, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			new BinaryTreeNode<U>(seed[start]);
		}
		BinaryTreeNode<U> root =  new BinaryTreeNode<U>(seed[end]);
		int smallerIndex = findSmallerIndex(seed,start, end - 1, seed[end]);
		root.setLeft(doConstruct(seed, start, smallerIndex));
		root.setRight(doConstruct(seed, smallerIndex + 1, end - 1));

		return root;
	}

	private static<U extends Comparable<? super U>> int findSmallerIndex(U[] seed, int start, int end, U cap) {
		int low = start;
		int high = end, mid;
		while (low < high) {
			mid = low +  (high - low + 1)/2;
			
			if (seed[mid].compareTo(cap) > 0) {
				high = mid - 1;
			} else {
				low = mid;
			}
		}
		return high;
	}
	
	public void printPreOrder(PrintStream s) {
		doPrintPreOrder(root, s);
	}

	private void doPrintPreOrder(BinaryTreeNode<T> node, PrintStream s) {
		if (node == null) {
			return ;
		}
		s.print(String.format("%d ", node.getData()));
		doPrintInOrder(node.getLeft(), s);
		doPrintInOrder(node.getRight(), s);
	}

	public void printInOrder(PrintStream s) {
		doPrintInOrder(root, s);
	}

	private void doPrintInOrder(BinaryTreeNode<T> node, PrintStream s) {
		if (node == null) {
			return ;
		}
		doPrintInOrder(node.getLeft(), s);
		s.print(String.format("%d ", node.getData()));
		doPrintInOrder(node.getRight(), s);
		
	}
}
