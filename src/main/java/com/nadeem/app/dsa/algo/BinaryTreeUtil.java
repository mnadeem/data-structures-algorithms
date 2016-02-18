package com.nadeem.app.dsa.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.nadeem.app.dsa.support.BinaryTreeNode;

public class BinaryTreeUtil {
	
	
	public static <U extends Comparable<? super U>> BinaryTreeNode<U> fromInAndPostOrder(U[] inOrder, U[] postOrder) {
		return doConstruct(inOrder, 0, inOrder.length -1, postOrder, 0, postOrder.length - 1);
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

	public static <T extends Comparable<? super T>> BinaryTreeNode<T> rMirror(BinaryTreeNode<T> root) {
		if (root != null) {
			BinaryTreeNode<T> temp = root.getRight();
			root.setRight(root.getLeft());
			root.setLeft(temp);

			rMirror(root.getLeft());
			rMirror(root.getRight());
		}
		return root;
	}
	
	public static <T extends Comparable<? super T>>  void printPostOrder(BinaryTreeNode<T> node, List<T> result) {
		if(node == null) {
			return ;
		}
		printPostOrder(node.getLeft(), result);
		printPostOrder(node.getRight(), result);
		result.add(node.getData());
	}
	


	public static <T extends Comparable<? super T>> void printPreOrder(BinaryTreeNode<T> node, List<T> result) {
		if (node == null) {
			return ;
		}
		result.add(node.getData());
		printPreOrder(node.getLeft(), result);
		printPreOrder(node.getRight(), result);
	}

	
	public static <T extends Comparable<? super T>>  void printInOrder(BinaryTreeNode<T> node, List<T> result) {
		if (node == null) {
			return ;
		}
		printInOrder(node.getLeft(), result);
		result.add(node.getData());
		printInOrder(node.getRight(), result);
	}

	public static <T extends Comparable<? super T>> BinaryTreeNode<T> iMirror(BinaryTreeNode<T> root) {
		if (root == null) {
			return null;
		}
		Deque<BinaryTreeNode<T>> stack = new ArrayDeque<BinaryTreeNode<T>>();
		stack.push(root);

		while(!stack.isEmpty()) {
			processNodes(stack);
		}
		return root;
	}

	private static <T extends Comparable<? super T>> void processNodes(Deque<BinaryTreeNode<T>> stack) {
		BinaryTreeNode<T> node = stack.pop();
		swapChildren(node);
		if (node.hasBothChildren()) {
			stack.push(node.getLeft());
			stack.push(node.getRight());
		}  else if(node.hasBothChildren()){
			stack.push(node.getLeft());
			stack.push(node.getRight());
		} else if (node.hasRightChild()){
			stack.push(node.getRight());
		}		
	}

	private static <T extends Comparable<? super T>> void swapChildren(BinaryTreeNode<T> root) {
		BinaryTreeNode<T> temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
	}

	public static int sumTree(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return 0;
		}
		int oldVal = node.getData();
		node.setData(sumTree(node.getLeft()) + sumTree(node.getRight()));

		return oldVal + node.getData();
	}

	public static <T extends Comparable<? super T>> List<List<T>> printAllPaths(BinaryTreeNode<T> node) {
		List <List<T>> paths = new ArrayList<List<T>>();
		doPrintAllPaths(node, paths, new ArrayList<T>());
		return paths;
	}

	private static <T extends Comparable<? super T>> void doPrintAllPaths(BinaryTreeNode<T> node, List<List<T>> allPaths, List<T> path) {
		if (node == null) {
			return ;
		}
		path.add(node.getData());
		if (node.isLeafNode()) {
			allPaths.add(new ArrayList<T>(path));
		} else {
			doPrintAllPaths(node.getLeft(), allPaths, path);
			doPrintAllPaths(node.getRight(), allPaths, path);
		}
		path.remove(node.getData());
	}

	public static <T extends Comparable<? super T>> List<T> printFromLeaf(BinaryTreeNode<T> root, BinaryTreeNode<T> leaf) {
		List<T> path =  new ArrayList<T>();
		doPrintSpecificPath(root, leaf, path);
		return path;
	}

	private static  <T extends Comparable<? super T>> boolean doPrintSpecificPath(BinaryTreeNode<T> node, BinaryTreeNode<T> leaf, List<T> path) {
		if (node == null) {
			return false;
		}
		// path.add(node.getData()); //For root to leaf order
		if (node == leaf || doPrintSpecificPath(node.getLeft(), leaf, path) || doPrintSpecificPath(node.getRight(), leaf, path)) {
			path.add(node.getData());
			return true;
		}
		return false;
	}

	public static int maxSum(BinaryTreeNode<Integer> node) {		
		return findMaxSum(node);
	}

	private static int findMaxSum(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return 0;
		}
		int leftSum = findMaxSum(node.getLeft());
		int rightSum = findMaxSum(node.getRight());

		int greaterSum = leftSum > rightSum ? leftSum : rightSum;
		return greaterSum + node.getData();
	}

	public static MaxSumPath maxSumPathFromRoot(BinaryTreeNode<Integer> node) {
		MaxSumPath maxSumPath = new MaxSumPath(0);
		doFindMaxSumPathFromRoot(node, 0, new ArrayList<Integer>(), maxSumPath);
		return maxSumPath;
	}
	// Note: Top to bottom, we have to pass arguments as parameter, bottom up we can return argument
	private static void doFindMaxSumPathFromRoot(BinaryTreeNode<Integer> node, int currentSum, List<Integer> paths, MaxSumPath maxSumPath) {
		if (node == null) {
			return;
		}
		currentSum += node.getData();
		paths.add(node.getData());
		if (node.isLeafNode()) {
			if (maxSumPath.updateSum(currentSum)) {
				maxSumPath.addPaths(paths);
			} 
		} else {
			doFindMaxSumPathFromRoot(node.getLeft(), currentSum, paths, maxSumPath);
			doFindMaxSumPathFromRoot(node.getRight(), currentSum, paths, maxSumPath);
		}		
		paths.remove(node.getData());
	}
}
