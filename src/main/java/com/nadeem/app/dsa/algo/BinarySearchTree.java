package com.nadeem.app.dsa.algo;

import java.util.List;

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
		BinaryTreeNode<U> root =  new BinaryTreeNode<U>(seed[end]);
		if (start == end) {
			return root;
		}
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

	public void printPostOrder(List<T> result) {
		BinaryTreeUtil.printPostOrder(root, result);
	}

	public void printPreOrder(List<T> result) {
		BinaryTreeUtil.printPreOrder(root, result);
	}

	public void printInOrder(List<T> result) {
		BinaryTreeUtil.printInOrder(root, result);
	}

	public static<U extends Comparable<? super U>> BinarySearchTree<U> fromPreAndNodeType(U[] preorder, char[] nodeType) {
		return new BinarySearchTree<U>(doConstructFromPreAndNodeType(preorder, new Index(), nodeType));
	}

	private static<U extends Comparable<? super U>> BinaryTreeNode<U> doConstructFromPreAndNodeType(U[] preorder, Index index, char[] nodeType) {
		if (index.isEqual(preorder.length)) {
			return null;
		}
		
		int indexVal = index.val;
		BinaryTreeNode<U> node = new BinaryTreeNode<U>(preorder[indexVal]);
		index.increment();
		
		if (nodeType[indexVal] == 'N') {
			node.setLeft(doConstructFromPreAndNodeType(preorder, index, nodeType));
			node.setRight(doConstructFromPreAndNodeType(preorder, index, nodeType));
		}
		return node;
	}

	private static class Index {
		private int val;
		public Index() {
			val = 0;
		}
		
		public boolean isEqual(int other) {
			return val == other;
		}
		public void increment() {
			val++;
		}
		
		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}

}
