package com.nadeem.app.dsa.algo;

import java.io.PrintStream;

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
		
		int rootIndex = rootIndexInOrder(inOrder, inS, inE, postOrder[pE]);
		root.setLeft(doConstruct(inOrder, inS, rootIndex - 1, postOrder, pS, pS + rootIndex-(inS + 1)));
		root.setRight(doConstruct(inOrder, rootIndex + 1,  inE, postOrder , pS + rootIndex - inS, pE -1));
		
		return root;
	}

	private static <U extends Comparable<? super U>> int rootIndexInOrder(U[] inOrder, int inS, int inE, U item) {
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

	public void printPostOrder(PrintStream s) {
		doPrintPostOrder(root, s);
	}
	
	private void doPrintPostOrder(BinaryTreeNode<T> node, PrintStream s) {
		if(node == null) {
			return ;
		}
		doPrintPostOrder(node.getLeft(), s);
		doPrintPostOrder(node.getRight(), s);
		s.print(String.format("%d ", node.getData()));		
	}

	public void printPreOrder(PrintStream s) {
		doPrintPreOrder(root, s);
	}

	private void doPrintPreOrder(BinaryTreeNode<T> node, PrintStream s) {
		if (node == null) {
			return ;
		}
		s.print(String.format("%d ", node.getData()));
		doPrintPreOrder(node.getLeft(), s);
		doPrintPreOrder(node.getRight(), s);
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
