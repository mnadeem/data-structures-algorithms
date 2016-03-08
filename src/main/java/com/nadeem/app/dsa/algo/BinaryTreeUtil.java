package com.nadeem.app.dsa.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.nadeem.app.dsa.support.BinaryTreeNode;
import com.nadeem.app.dsa.support.MaxSumPath;
import com.nadeem.app.dsa.support.MutableInteger;
import com.nadeem.app.dsa.support.MutableValue;

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
		stack.offer(root);

		while(!stack.isEmpty()) {
			processNodesForMirroring(stack);
		}
		return root;
	}

	private static <T extends Comparable<? super T>> void processNodesForMirroring(Deque<BinaryTreeNode<T>> stack) {
		BinaryTreeNode<T> node = stack.poll();
		swapChildren(node);
		if (node.hasBothChildren()) {
			stack.push(node.getLeft());
			stack.push(node.getRight());
		}  else if(node.hasLeftChild()){
			stack.push(node.getLeft());
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

	public static int maxSumFromRoot(BinaryTreeNode<Integer> node) {		
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

	public static int maxSumBetweenTwoLeaves(BinaryTreeNode<Integer> node) {
		return doFindMaxSumBtnTwoLeaves(node).getMaxSum();
	}

	private static MaxSumPath doFindMaxSumBtnTwoLeaves(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return new MaxSumPath(0, 0);
		} else if(node.isLeafNode()) {
			return new MaxSumPath(node.getData(), node.getData());
		} else {
			MaxSumPath leftSum = doFindMaxSumBtnTwoLeaves(node.getLeft());
			MaxSumPath rightSum = doFindMaxSumBtnTwoLeaves(node.getRight());
			int maxSumSoFar = Math.max(leftSum.getCurrentSum() + rightSum.getCurrentSum() + node.getData(), Math.max(leftSum.getCurrentSum(), rightSum.getCurrentSum()));
			int nodeMaxSum = Math.max(leftSum.getCurrentSum(), rightSum.getCurrentSum()) + node.getData();
			return new MaxSumPath(nodeMaxSum, maxSumSoFar);
		}
	}

	public static List<List<Integer>> rootToLeafPathsForSum(BinaryTreeNode<Integer> node, int requiredSum) {
		List <List<Integer>> paths = new ArrayList<List<Integer>>();
		doFindRootToLeafPathsForSum(node, 0, requiredSum, new ArrayList<Integer>(), paths);
		return paths;
	}

	private static void doFindRootToLeafPathsForSum(BinaryTreeNode<Integer> node, int sum, int requiredSum,
			List<Integer> path, List<List<Integer>> paths) {
		if(node == null) {
			return ;
		} 
		path.add(node.getData());
		sum +=node.getData();
		if (node.isLeafNode()) {
			if (sum == requiredSum) {
				paths.add(new ArrayList<Integer>(path));
			}			
		} else {
			doFindRootToLeafPathsForSum(node.getLeft(), sum,  requiredSum, path, paths);
			doFindRootToLeafPathsForSum(node.getRight(), sum, requiredSum, path, paths);
			
		}
		path.remove(node.getData());
	}

	public static int sumNumbersFromRoot2Leaf(BinaryTreeNode<Integer> node) {
		List<Integer> items = new ArrayList<Integer>();
		findSumNumbersFromRoot2Leaf(node, 0, items);
		int sum = 0;
		for (Integer item : items) {
			sum += item;
		}
		return sum;
	}

	private static void findSumNumbersFromRoot2Leaf(BinaryTreeNode<Integer> node, int sum, List<Integer> items) {
		if (node == null) {
			return ;
		}
		sum =sum *10 + node.getData();
		if (node.isLeafNode()) {
			items.add(sum);
		} else {
			findSumNumbersFromRoot2Leaf(node.getLeft(), sum, items);
			findSumNumbersFromRoot2Leaf(node.getRight(), sum, items);
		}		
	}

	public static  <T extends Comparable<? super T>> int height(BinaryTreeNode<T> node) {
		if (node == null) {
			return 0;
		}
		int lh = height(node.getLeft());
		int rh = height(node.getRight());
		return Math.max(lh, rh) + 1;
	}
	

	public static  <T extends Comparable<? super T>> List<List<T>> rLevelOrder(BinaryTreeNode<T> node) {
		List<List<T>> result = new ArrayList<List<T>>();
		List<T> levelOrder;
		int height = height(node);
		for (int level = 1; level <= height; level++) {
			levelOrder = new ArrayList<T>();
			doRLevelOrder(node, level, levelOrder);
			result.add(levelOrder);			
		}
		return result;
	}

	private static <T> void doRLevelOrder(BinaryTreeNode<T> node, int level, List<T> levelOrder) {
		if (node == null) {
			return ;
		}
		if (level == 1) {
			levelOrder.add(node.getData());
		}
		doRLevelOrder(node.getLeft(), level - 1, levelOrder);
		doRLevelOrder(node.getRight(), level - 1, levelOrder);
		
	}

	public static <T extends Comparable<? super T>> List<List<T>> levelOrder(BinaryTreeNode<T> root) {
		List<List<T>> result = new ArrayList<List<T>>();
		if (root != null) {
			Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				List<T> level = new ArrayList<T>();
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					BinaryTreeNode<T> node = queue.poll();
					level.add(node.getData());
					if (node.hasLeftChild()) {
						queue.offer(node.getLeft());
					}
					if (node.hasRightChild()) {
						queue.offer(node.getRight());
					}
				}
				result.add(level);				
			}
		}	
		
		return result;
	}

	public static <T extends Comparable<? super T>> List<T> iRightView(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		if (root != null) {
			Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					BinaryTreeNode<T> node = queue.poll();
					if (i==0) {
						result.add(node.getData());
					}
					if (node.hasRightChild()) {
						queue.offer(node.getRight());
					}
					if (node.hasLeftChild()) {
						queue.offer(node.getLeft());
					}
				}
			}
		}
		return result;
	}

	public static<T extends Comparable<? super T>> List<T> rRightView(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		bfsRightView(root, 1, new MutableInteger(0), result);
		return result;
	}

	private static <T extends Comparable<? super T>> void bfsRightView(BinaryTreeNode<T> node, int currentLevel, MutableInteger  maxLevelSoFar, List<T> result) {
		if (node == null) {
			return ;
		}
		if (maxLevelSoFar.updateForMax(currentLevel)) {
			result.add(node.getData());
		}
		bfsRightView(node.getRight(), currentLevel + 1, maxLevelSoFar, result);
		bfsRightView(node.getLeft(), currentLevel + 1, maxLevelSoFar, result);		
	}

	public static <T extends Comparable<? super T>> List<List<T>> verticalView(BinaryTreeNode<T> node) {
		List<List<T>> result = new ArrayList<List<T>>();
		MutableInteger min = new MutableInteger(0);
		MutableInteger max = new MutableInteger(0);
		findMinMaxHD(node, min, max, 0);

		printVeritcalVew(node, min.getValue(), max.getValue(), result);

		return result;
	}

	private static <T extends Comparable<? super T>> void findMinMaxHD(BinaryTreeNode<T> node, MutableInteger min, MutableInteger max, int hd) {
		if (node == null) {
			return;
		}
		min.updateForMin(hd);
		max.updateForMax(hd);
		findMinMaxHD(node.getLeft(), min, max, hd - 1);
		findMinMaxHD(node.getRight(), min, max, hd + 1);
	}
	
	private static <T extends Comparable<? super T>> void printVeritcalVew(BinaryTreeNode<T> node, Integer min, Integer max, List<List<T>> result) {
		if (node == null) {
			return ;
		}
		
		for (int lineNo = min; lineNo <= max; lineNo++) {
			List<T> lineResult = new ArrayList<T>();
			doPrintVerticalView(node, lineNo, 0, lineResult);
			result.add(lineResult);
		}
	}

	private static <T extends Comparable<? super T>> void doPrintVerticalView(BinaryTreeNode<T> node, int lineNo, int hd, List<T> lineResult) {
		if (node == null) {
			return ;
		}
		if (lineNo == hd) {
			lineResult.add(node.getData());
		}
		doPrintVerticalView(node.getLeft(), lineNo, hd - 1, lineResult);
		doPrintVerticalView(node.getRight(), lineNo, hd + 1, lineResult);
		
	}

	public static<T extends Comparable<? super T>> List<List<T>> mapBasedVerticalView(BinaryTreeNode<T> node) {
		Map<Integer, List<BinaryTreeNode<T>>> map = new TreeMap<Integer, List<BinaryTreeNode<T>>>();
		List<List<T>> result = new ArrayList<List<T>>();
		populateHDMap(node, 0 , map);
		populateResult(map, result);
		return result;
	}

	private static<T extends Comparable<? super T>> void populateHDMap(BinaryTreeNode<T> node, int hd, Map<Integer, List<BinaryTreeNode<T>>> map) {
		if (node == null) {
			return ;
		}
		updateHDNode(node, hd, map);
		populateHDMap(node.getLeft(), hd - 1, map);
		populateHDMap(node.getRight(), hd + 1, map);

	}
	
	private static <T extends Comparable<? super T>> void updateHDNode(BinaryTreeNode<T> node, Integer hd, Map<Integer, List<BinaryTreeNode<T>>> map) {
		List<BinaryTreeNode<T>> list = map.get(hd);
		if (list == null) {
			list = new ArrayList<BinaryTreeNode<T>>();
			map.put(hd, list);
		}
		list.add(node);
	}

	private static<T extends Comparable<? super T>> void populateResult(Map<Integer, List<BinaryTreeNode<T>>> map, List<List<T>> result) {
		for (Map.Entry<Integer, List<BinaryTreeNode<T>>> entry : map.entrySet()) {
			List<T> items = new ArrayList<T>();
			for (BinaryTreeNode<T> bt :entry.getValue()) {
				items.add(bt.getData());
			}
			result.add(items);
		}
	}

	public static <T extends Comparable<? super T>> Collection<T> topView(BinaryTreeNode<T> root) {
		Map<Integer, BinaryTreeNode<T>> map = new TreeMap<Integer, BinaryTreeNode<T>>();
		Queue<HdBinaryTreeNode<T>> queue = new LinkedList<HdBinaryTreeNode<T>>();
		queue.offer(new HdBinaryTreeNode<T>(root, 0));
		
		while (!queue.isEmpty()) {
			HdBinaryTreeNode<T> hdNode = queue.poll();
			
			if (!map.containsKey(hdNode.getHd())) {
				map.put(hdNode.getHd(), hdNode.getNode());
			}
			
			if (hdNode.getNode().hasLeftChild()) {
				queue.offer(new HdBinaryTreeNode<T>(hdNode.getNode().getLeft(), hdNode.getHd() - 1));
			}
			if (hdNode.getNode().hasRightChild()) {
				queue.offer(new HdBinaryTreeNode<T>(hdNode.getNode().getRight(), hdNode.getHd() + 1));
			}
		}
		
		List<T> result = new ArrayList<T>();
		for (Map.Entry<Integer, BinaryTreeNode<T>> t : map.entrySet()) {
			result.add(t.getValue().getData());
		}
		
		return result;
	}
	
	private static class HdBinaryTreeNode<T> {
		private BinaryTreeNode<T> node;
		private Integer hd;
		public HdBinaryTreeNode(BinaryTreeNode<T> node, Integer hd) {
			this.node = node;
			this.hd = hd;
		}
		public BinaryTreeNode<T> getNode() {
			return node;
		}
		
		public Integer getHd() {
			return hd;
		}			
	}

	public static  Collection<Integer> verticalSum(BinaryTreeNode<Integer> node) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		populateVerticalSumMap(node, 0, map);
	
		return map.values();
	}

	private static void populateVerticalSumMap(BinaryTreeNode<Integer> node, int hd, Map<Integer, Integer> map) {
		if (node == null) {
			return ;
		}
		Integer hdSum  = map.get(hd);
		if (hdSum == null) {
			hdSum = 0;
		}
		map.put(hd, hdSum + node.getData());	
		populateVerticalSumMap(node.getLeft(), hd - 1, map);
		
		populateVerticalSumMap(node.getRight(), hd + 1, map);
	}

	public static <T extends Comparable<? super T>> void zigZagLevelTravelsal(BinaryTreeNode<T> node) {
		if (node == null) {
			return ;
		}
		Deque<BinaryTreeNode<T>> currentLevelStack = new ArrayDeque<BinaryTreeNode<T>>();
		Deque<BinaryTreeNode<T>> nextLevelStack = null;
		boolean leftToRight = true;
		
		currentLevelStack.push(node);
		
		nextLevelStack = new ArrayDeque<BinaryTreeNode<T>>();
		while (!currentLevelStack.isEmpty()) {
			BinaryTreeNode<T> temp = currentLevelStack.pop();
			System.out.print(temp.getData()+ " ");
			if (leftToRight) {
				if (temp.hasLeftChild()) {
					nextLevelStack.push(temp.getLeft());
				}	
				if (temp.hasRightChild()) {
					nextLevelStack.push(temp.getRight());
				}
			} else {
				if (temp.hasRightChild()) {
					nextLevelStack.push(temp.getRight());
				}
				if (temp.hasLeftChild()) {
					nextLevelStack.push(temp.getLeft());
				}
			}
			if (currentLevelStack.isEmpty()) {
				leftToRight = !leftToRight;
				Deque<BinaryTreeNode<T>> tempStack = currentLevelStack;
				currentLevelStack = nextLevelStack;
				nextLevelStack = tempStack;
				System.out.println();
			}			
		}		
	}

	public static<T> boolean isTreeBalanced(BinaryTreeNode<T> node) {
		return doCheckBalance(node) != -1;
	}

	private static <T> int doCheckBalance(BinaryTreeNode<T> node) {
		if (node == null) {
			return 0;
		}
		int left = doCheckBalance(node.getLeft());
		
		if (left == -1) {
			return -1;
		}
		
		int right = doCheckBalance(node.getRight());
		
		if (right == -1) {
			return -1;
		}
		
		if (Math.abs(left - right) > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}

	public static <T> BinaryTreeNode<T> LCA(BinaryTreeNode<T> root, T a, T b) {
		if (root == null) {
			return null;
		}
		
		if (root.getData().equals(a) || root.getData().equals(b)) {
			return root;
		}
		
		BinaryTreeNode<T> left = LCA(root.getLeft(), a, b);
		BinaryTreeNode<T> right = LCA(root.getRight(), a, b);
		
		if (left != null && right != null) {
			return root;
		}
		
		return left==null ? right : left;
	}

	public static<T extends Comparable<? super T>> int distanceFromRoot(BinaryTreeNode<T> node, T key) {
		return numberOfNodes(node, key) - 1;
	}

	public static<T extends Comparable<? super T>> int numberOfNodes(BinaryTreeNode<T> node, T key) {
		if (node == null) {
			return 0;
		}
		int numberOfNodes = 0;
		if (node.getData().equals(key) 
				|| (numberOfNodes = numberOfNodes(node.getLeft(), key)) > 0 
				||  (numberOfNodes = numberOfNodes(node.getRight(), key)) > 0 ) {
			return numberOfNodes + 1;
		}		
		return 0;
	}

	public static <T extends Comparable<? super T>> int distanceBetween(BinaryTreeNode<T> node, T n1, T n2) {
		int n1Distance = distanceFromRoot(node, n1);
		if (n1Distance == -1) {
			throw new IllegalArgumentException("Invalid " + n1);
		}

		int n2Distance = distanceFromRoot(node, n2);
		if (n2Distance == -1) {
			throw new IllegalArgumentException("Invalid " + n2);
		}
		
		BinaryTreeNode<T> lca = LCA(node, n1, n2);
		int lcaDistance = distanceFromRoot(node, lca.getData());
		if (lcaDistance == -1) {
			throw new IllegalArgumentException("Invalid " + lca.getData());
		}

		return n1Distance + n2Distance - 2 * lcaDistance;
	}

	public static Integer[] printPostOrderWithOutConstructingTree(int[] inOrder, int[] preOrder) {
		List<Integer> result = new ArrayList<Integer>();
		doPrintPostOrderWithOutConstructingTree(inOrder, 0, inOrder.length-1, preOrder, new MutableInteger(0), result);
		return result.toArray(new Integer[0]);
	}

	private static void doPrintPostOrderWithOutConstructingTree(int[] inOrder, int start, int end, int[] preOrder, MutableInteger preIndex,
			List<Integer> result) {
		if (start >  end) {
			return ;
		}
		int rootIndex = searchInOrder(inOrder, start, end, preOrder[preIndex.getValue()]);
		int currIndex = preIndex.getValue();
		preIndex.increment();
		doPrintPostOrderWithOutConstructingTree(inOrder, start, rootIndex - 1, preOrder, preIndex, result);
		doPrintPostOrderWithOutConstructingTree(inOrder, rootIndex + 1, end, preOrder, preIndex, result);				
		result.add(preOrder[currIndex]);
		
	}

	public static Integer[] printPreOrderWithOutConstructingTree(int[] inOrder, int[] postOrder) {
		List<Integer> result = new ArrayList<Integer>();
		doPrintPreOrderWithOutConstructingTree(inOrder, 0, inOrder.length-1, postOrder, 0, postOrder.length - 1, result);
		return result.toArray(new Integer[0]);
	}

	private static void doPrintPreOrderWithOutConstructingTree(int[] inOrder, int inStart, int inEnd, int[] postOrder,
			int pStart, int pEnd, List<Integer> result) {
		if (inStart > inEnd) {
			return ;
		}
		
		int rootIndex = searchInOrder(inOrder, inStart, inEnd, postOrder[pEnd]);
		if (rootIndex == -1) {
			return ;
		}
		result.add(postOrder[pEnd]);
		if (inEnd - inStart <= 3) {
			for (int i = pStart; i < pEnd; i++) {
				result.add(postOrder[i]);
			}
		} else {
		
			doPrintPreOrderWithOutConstructingTree(inOrder, inStart, rootIndex - 1, postOrder, pStart, rootIndex-1, result);
			doPrintPreOrderWithOutConstructingTree(inOrder, rootIndex + 1, inEnd, postOrder, rootIndex, pEnd - 1, result);
		}
	}

	private static int searchInOrder(int[] inOrder, int start, int end, int preElement) {
		while (start <= end) {
			if (inOrder[start] == preElement) {
				return start;
			}
			start ++;			
		}
		return -1;
	}

	public static <T extends Comparable<? super T>> void populateInOrderTraversalOfAllNodes(BinaryTreeNode<T> node) {
		doPopulateInOrderTraversalOfAllNodes(node, new MutableValue<BinaryTreeNode<T>>(null));
	}

	private static <T extends Comparable<? super T>>  void doPopulateInOrderTraversalOfAllNodes(BinaryTreeNode<T> node, MutableValue<BinaryTreeNode<T>> next) {
		if (node != null) {			
			doPopulateInOrderTraversalOfAllNodes(node.getRight(), next);
			node.setNext(next.getValue());
			next.setValue(node);
			doPopulateInOrderTraversalOfAllNodes(node.getLeft(), next);
		}
	}

}
