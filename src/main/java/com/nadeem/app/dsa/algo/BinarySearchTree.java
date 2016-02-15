package com.nadeem.app.dsa.algo;

import java.util.List;

import com.nadeem.app.dsa.support.BinaryTreeNode;

public class BinarySearchTree <T extends Comparable<? super T>> {
	
	private BinaryTreeNode<T> root;

	private BinarySearchTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	public static <U extends Comparable<? super U>> BinarySearchTree<U> fromInAndPostOrder(U[] inOrder, U[] postOrder) {
		return new BinarySearchTree<U>(doConstruct(inOrder, 0, inOrder.length -1, postOrder, 0, postOrder.length - 1));
	}

	private static <U extends Comparable<? super U>> BinaryTreeNode<U> doConstruct(U[] inOrder, int inS, int inE, U[] postOrder, int pS, int pE) {
		if (inS > inE || pS > pE) {
			return null;
		}
		BinaryTreeNode<U> root = new BinaryTreeNode<U>(postOrder[pE]);
		
		if (inS == inE) {
			return root;
		}
		
		int divideIndex = divideIndexInOrder(inOrder, inS, inE, postOrder[pE]);
		root.setLeft(doConstruct(inOrder, inS, divideIndex - 1, postOrder, pS, pS + divideIndex-(inS + 1)));
		root.setRight(doConstruct(inOrder, divideIndex + 1,  inE, postOrder , pS + divideIndex - inS, pE -1));
		
		return root;
	}

	private static <U extends Comparable<? super U>> int divideIndexInOrder(U[] inOrder, int inS, int inE, U item) {
		for (int i = 0; i < inOrder.length; i++) {
			if (item.compareTo(inOrder[i]) == 0) {
				
				return i;
			}
		}
		return 0;
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
		doPrintPostOrder(root, result);
	}
	
	private void doPrintPostOrder(BinaryTreeNode<T> node, List<T> result) {
		if(node == null) {
			return ;
		}
		doPrintPostOrder(node.getLeft(), result);
		doPrintPostOrder(node.getRight(), result);
		result.add(node.getData());
	}

	public void printPreOrder(List<T> result) {
		doPrintPreOrder(root, result);
	}

	private void doPrintPreOrder(BinaryTreeNode<T> node, List<T> result) {
		if (node == null) {
			return ;
		}
		result.add(node.getData());
		doPrintPreOrder(node.getLeft(), result);
		doPrintPreOrder(node.getRight(), result);
	}

	public void printInOrder(List<T> result) {
		doPrintInOrder(root, result);
	}

	private void doPrintInOrder(BinaryTreeNode<T> node, List<T> result) {
		if (node == null) {
			return ;
		}
		doPrintInOrder(node.getLeft(), result);
		result.add(node.getData());
		doPrintInOrder(node.getRight(), result);
		
	}

	public static<U extends Comparable<? super U>> BinarySearchTree<U> fromPreAndNodeType(U[] preorder, char[] nodeType) {
		// TODO Auto-generated method stub
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
