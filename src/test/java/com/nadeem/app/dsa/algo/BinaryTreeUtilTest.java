package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.nadeem.app.dsa.support.BinaryTreeNode;
import com.nadeem.app.dsa.support.MaxSumPath;

public class BinaryTreeUtilTest {

	@Test
	public void constructFromInAndPost() {
		BinaryTreeNode<Integer> bst = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});
		List<Integer> result = new ArrayList<Integer>();
		BinaryTreeUtil.printInOrder(bst, result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{4, 2, 5, 1, 6, 3, 7}));
		result.clear();
		BinaryTreeUtil.printPreOrder(bst, result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{1, 2, 4, 5, 3, 6, 7}));
		result.clear();
		BinaryTreeUtil.printPostOrder(bst, result);			
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{4, 5, 2, 6, 7, 3, 1}));
		result.clear();

	}

	@Test
	public void recursiveMirrorTest() {
		BinaryTreeNode<Integer> bt = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});
		BinaryTreeNode<Integer> mirror = BinaryTreeUtil.<Integer>rMirror(bt);
		List<Integer> result = new ArrayList<Integer>();
		BinaryTreeUtil.printInOrder(mirror, result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{7,3,6,1,5,2,4}));
	}
	
	@Test
	public void iterativeMirrorTest() {
		BinaryTreeNode<Integer> bt = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});
		BinaryTreeNode<Integer> mirror = BinaryTreeUtil.<Integer>iMirror(bt);
		List<Integer> result = new ArrayList<Integer>();
		BinaryTreeUtil.printInOrder(mirror, result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{7,3,6,1,5,2,4}));
	}
	
	@Test
	public void sumTreeTest() {
		BinaryTreeNode<Integer> bt = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{8,-2,-4,10,7,6,5}, new Integer[]{8,-4,-2,7,5,6,10});
		BinaryTreeUtil.sumTree(bt);
		List<Integer> result = new ArrayList<Integer>();
		BinaryTreeUtil.printInOrder(bt, result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{0, 4, 0, 20, 0, 12, 0}));
		//System.out.println(Arrays.toString(result.toArray()));
	}

	@Test
	public void printAllPaths() {
		BinaryTreeNode<Integer> bt = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,6,1,7,3}, new Integer[]{4,6,5,2,7,3,1});
		List <List<Integer>> paths = BinaryTreeUtil.printAllPaths(bt);
		
		assertThat(paths.get(0).toArray(new Integer[0]), equalTo(new Integer[]{1, 2, 4}));
		assertThat(paths.get(1).toArray(new Integer[0]), equalTo(new Integer[]{1, 2, 5, 6}));
		assertThat(paths.get(2).toArray(new Integer[0]), equalTo(new Integer[]{1, 3, 7}));

		for (List<Integer> list : paths) {			
			for (Integer integer : list) {
				System.out.print(String.format(" %d", integer));
			}
			System.out.println();
		}
	}
	
	@Test
	public void printSpecificPath() {
		BinaryTreeNode<Integer> bt = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,6,1,7,3}, new Integer[]{4,6,5,2,7,3,1});
		BinaryTreeNode<Integer> node = bt.getLeft().getRight().getRight();
		
		List<Integer> path = BinaryTreeUtil.printFromLeaf(bt, node);
		
		assertThat(path.toArray(new Integer[0]), equalTo(new Integer[]{6,5,2,1}));		

	}
	
	@Test
	public void maxSumTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,-6,1,7,3}, new Integer[]{4,-6,5,2,7,3,1});
		int sum = BinaryTreeUtil.maxSumFromRoot(node);
		assertThat(sum, is(11));
	}
	
	@Test
	public void maxSumPathFromRootTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,-6,1,7,3}, new Integer[]{4,-6,5,2,7,3,1});
		MaxSumPath sumPath = BinaryTreeUtil.maxSumPathFromRoot(node);
		assertThat(sumPath.getMaxSum(), is(11));
		assertThat(sumPath.getPath().toArray(new Integer[0]), equalTo(new Integer[]{1,3,7}));	
	}
	
	@Test
	public void maxSumPathBetweenTwoLeavesTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,-6,1,7,3}, new Integer[]{4,-6,5,2,7,3,1});
		int sum = BinaryTreeUtil.maxSumBetweenTwoLeaves(node);
		assertThat(sum, is(18));
		
		node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,6,1,7,3}, new Integer[]{4,6,5,2,7,3,1});
		sum = BinaryTreeUtil.maxSumBetweenTwoLeaves(node);
		assertThat(sum, is(24));
	}
	
	@Test
	public void allRoot2LeafPathsForGivenSumTest() {
		BinaryTreeNode<Integer> bt = buildTree();
		List <List<Integer>> paths = BinaryTreeUtil.rootToLeafPathsForSum(bt, 14);

		assertThat(paths.size(), is(2));

		assertThat(paths.get(0).toArray(new Integer[0]), equalTo(new Integer[]{1,2,5,6}));
		assertThat(paths.get(1).toArray(new Integer[0]), equalTo(new Integer[]{1,3,7,3}));
		
		for (List<Integer> list : paths) {			
			for (Integer integer : list) {
				System.out.print(String.format(" %d", integer));
			}
			System.out.println();
		}
	}
	
	@Test
	public void sumOfAllNumbersFormedFromRoot2LeafTest() {
		BinaryTreeNode<Integer> bt = buildTree();
		int sum = BinaryTreeUtil.sumNumbersFromRoot2Leaf(bt);

		assertThat(sum, is(2753));
		
	}

	@Test
	public void heightTest() {
		BinaryTreeNode<Integer> node = buildTree();
		int height = BinaryTreeUtil.height(node);

		assertThat(height, is(4));
		assertThat(BinaryTreeUtil.height(null), is(0));
		assertThat(BinaryTreeUtil.height(new BinaryTreeNode<Integer>(4)), is(1));
	}
	
	@Test
	public void rLevelOrderTraversalTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});
		List <List<Integer>> levelOrder = BinaryTreeUtil.<Integer>rLevelOrder(node);
		
		assertThat(levelOrder.size(), is(3));
		assertThat(levelOrder.get(0).toArray(new Integer[0]), equalTo(new Integer[]{1}));
		assertThat(levelOrder.get(1).toArray(new Integer[0]), equalTo(new Integer[]{2,3}));
		assertThat(levelOrder.get(2).toArray(new Integer[0]), equalTo(new Integer[]{4,5,6,7}));
	}
	
	@Test
	public void iLevelOrderTraversalTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});

		List <List<Integer>> levelOrder = BinaryTreeUtil.<Integer>levelOrder(node);
		
		assertThat(levelOrder.size(), is(3));
		assertThat(levelOrder.get(0).toArray(new Integer[0]), equalTo(new Integer[]{1}));
		assertThat(levelOrder.get(1).toArray(new Integer[0]), equalTo(new Integer[]{2,3}));
		assertThat(levelOrder.get(2).toArray(new Integer[0]), equalTo(new Integer[]{4,5,6,7}));

		for (List<Integer> list : levelOrder) {			
			for (Integer integer : list) {
				System.out.print(String.format(" %d", integer));
			}
			System.out.println();
		}
	}
	
	@Test
	public void iRightViewOfBinaryTreeTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});

		List<Integer> rightView = BinaryTreeUtil.<Integer>iRightView(node);
		
		assertThat(rightView.toArray(new Integer[0]), equalTo(new Integer[]{1,3,7}));

	}
	
	@Test
	public void rRightViewOfBinaryTreeTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});

		List<Integer> rightView = BinaryTreeUtil.<Integer>rRightView(node);
		
		assertThat(rightView.toArray(new Integer[0]), equalTo(new Integer[]{1,3,7}));

	}
	
	@Test
	public void printVerticalViewTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});

		List<List<Integer>> rightView = BinaryTreeUtil.<Integer>verticalView(node);
		
		assertThat(rightView.size(), is(5));
		assertThat(rightView.get(0).toArray(new Integer[0]), equalTo(new Integer[]{4}));
		assertThat(rightView.get(1).toArray(new Integer[0]), equalTo(new Integer[]{2}));
		assertThat(rightView.get(2).toArray(new Integer[0]), equalTo(new Integer[]{1,5,6}));
		assertThat(rightView.get(3).toArray(new Integer[0]), equalTo(new Integer[]{3}));
		assertThat(rightView.get(4).toArray(new Integer[0]), equalTo(new Integer[]{7}));
	}
	
	@Test
	public void printMapBasedVerticalViewTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});

		List<List<Integer>> rightView = BinaryTreeUtil.<Integer>mapBasedVerticalView(node);
		
		assertThat(rightView.size(), is(5));
		assertThat(rightView.get(0).toArray(new Integer[0]), equalTo(new Integer[]{4}));
		assertThat(rightView.get(1).toArray(new Integer[0]), equalTo(new Integer[]{2}));
		assertThat(rightView.get(2).toArray(new Integer[0]), equalTo(new Integer[]{1,5,6}));
		assertThat(rightView.get(3).toArray(new Integer[0]), equalTo(new Integer[]{3}));
		assertThat(rightView.get(4).toArray(new Integer[0]), equalTo(new Integer[]{7}));
	}
	
	@Test
	public void printTopViewTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});

		Collection<Integer> rightView = BinaryTreeUtil.<Integer>topView(node);
		
		assertThat(rightView.toArray(new Integer[0]), equalTo(new Integer[]{4,2,1,3,7}));
	}

	@Test
	public void verticalSumOfBinaryTreeTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});

		Collection<Integer> verticalSum = BinaryTreeUtil.verticalSum(node);
		
		assertThat(verticalSum.toArray(new Integer[0]), equalTo(new Integer[]{4,2,12,3,7}));
	}
	
	@Test
	public void recursiveZigZagLevelOrderTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});
		List<List<Integer>> result = BinaryTreeUtil.rZigZagTraversal(node);
		
		assertThat(result.size(), is(3));
		assertThat(result.get(0).toArray(new Integer[0]), equalTo(new Integer[]{1}));
		assertThat(result.get(1).toArray(new Integer[0]), equalTo(new Integer[]{3, 2}));
		assertThat(result.get(2).toArray(new Integer[0]), equalTo(new Integer[]{4,5,6, 7}));
	}
	
	@Test
	public void iterativeZigZagLevelTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});

		BinaryTreeUtil.iZigZagLevelTravelsal(node);

	}
	
	@Test
	public void balancedTreeTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});
		boolean isBalanced = BinaryTreeUtil.isTreeBalanced(node);
		assertThat(isBalanced, equalTo(true));
		
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2, n4, n6);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, null, n2);
		
		isBalanced = BinaryTreeUtil.isTreeBalanced(root);
		assertThat(isBalanced, equalTo(false));
	}
	
	@Test
	public void LCAtest() {
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5, null, n6);
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2, n4, n5);
		BinaryTreeNode<Integer> n31 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7, null, n31);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3, n7, null);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, n2, n3);
		
		BinaryTreeNode<Integer> result = BinaryTreeUtil.LCA(root, 6, 4);
		assertThat(result, equalTo(n2));
		
		result = BinaryTreeUtil.LCA(root, 4, 5);
		assertThat(result, equalTo(n2));
		
		result = BinaryTreeUtil.LCA(root, 4, 7);
		assertThat(result, equalTo(root));
		
		result = BinaryTreeUtil.LCA(root, 5, 6);
		assertThat(result, equalTo(n5));
		
		result = BinaryTreeUtil.LCA(root, 700, 6);
		assertThat(result, equalTo(n6));
	}
	
	@Test
	public void distanceFromRoot2NodeTest() {
		BinaryTreeNode<Integer> node = buildTree();
		int distance = BinaryTreeUtil.distanceFromRoot(node, 6);
		assertThat(distance, equalTo(3));
		
		distance = BinaryTreeUtil.distanceFromRoot(node, 7);
		assertThat(distance, equalTo(2));
		
		distance = BinaryTreeUtil.distanceFromRoot(node, 1);
		assertThat(distance, equalTo(0));
	}
	
	@Test
	public void distanceBetween2NodeTest() {
		BinaryTreeNode<Integer> root = buildTree();
		int distance = BinaryTreeUtil.distanceBetween(root, 6, 4);
		assertThat(distance, equalTo(3));
		
		distance = BinaryTreeUtil.distanceBetween(root, 4, 7);
		assertThat(distance, equalTo(4));
		
		distance = BinaryTreeUtil.distanceBetween(root, 2, 3);
		assertThat(distance, equalTo(2));

	}
	
	@Test
	public void printPostOrderWithoutConstructingTreeTest() {
		int inOrder[] = {4, 2, 5, 1, 3, 6};
		int preOrder[] = {1, 2, 4, 5, 3, 6};
		Integer postOrder[] = BinaryTreeUtil.printPostOrderWithOutConstructingTree(inOrder, preOrder);
		assertThat(postOrder, equalTo(new Integer[]{4, 5, 2, 6, 3, 1}));
	}
	
	@Test
	public void printPreOrderWithoutConstructingTreeTest() {
		int inOrder[] = {4, 2, 5, 1, 3, 6};
		int postOrder[] = {4, 5, 2, 6, 3, 1};
		Integer preOrder[] = BinaryTreeUtil.printPreOrderWithOutConstructingTree(inOrder, postOrder);
		assertThat(preOrder, equalTo(new Integer[]{1, 2, 4, 5, 3, 6}));
	}

	@Test
	public void populateInOrderTraversalOfAllNodesTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});
		BinaryTreeUtil.populateInOrderTraversalOfAllNodes(node);
		
		Map<Integer, Integer> inOrderSuccessorMapping = new LinkedHashMap<Integer, Integer>();
		
		doPopulate(node, inOrderSuccessorMapping);
		
		assertThat(inOrderSuccessorMapping.get(4), equalTo(2));
		assertThat(inOrderSuccessorMapping.get(2), equalTo(5));
		assertThat(inOrderSuccessorMapping.get(5), equalTo(1));
		assertThat(inOrderSuccessorMapping.get(1), equalTo(6));
		assertThat(inOrderSuccessorMapping.get(6), equalTo(3));
		assertThat(inOrderSuccessorMapping.get(3), equalTo(7));
		
	}
	
	@Test
	public void populateRightNeighbourTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,1,6,3,7}, new Integer[]{4,5,2,6,7,3,1});
		BinaryTreeUtil.populateRightNeighbour(node);
		
	}

	private void doPopulate(BinaryTreeNode<Integer> node, Map<Integer, Integer> inOrderSuccessorMapping) {
		if (node != null) {
			doPopulate(node.getLeft(), inOrderSuccessorMapping);
			if (node.getNext() != null) {				
				inOrderSuccessorMapping.put(node.getData(), node.getNext().getData());
			}
			doPopulate(node.getRight(), inOrderSuccessorMapping);
		}		
	}

	private BinaryTreeNode<Integer> buildTree() {
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5, null, n6);
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2, n4, n5);
		BinaryTreeNode<Integer> n31 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7, null, n31);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3, n7, null);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, n2, n3);
		
		return root;
	}
	
}
