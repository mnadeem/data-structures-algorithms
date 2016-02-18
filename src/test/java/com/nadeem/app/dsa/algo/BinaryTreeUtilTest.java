package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nadeem.app.dsa.support.BinaryTreeNode;

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
		int sum = BinaryTreeUtil.maxSum(node);
		assertThat(sum, is(11));
	}
	
	@Test
	public void maxSumPathFromRootTest() {
		BinaryTreeNode<Integer> node = BinaryTreeUtil.<Integer>fromInAndPostOrder(new Integer[]{4,2,5,-6,1,7,3}, new Integer[]{4,-6,5,2,7,3,1});
		MaxSumPath sumPath = BinaryTreeUtil.maxSumPathFromRoot(node);
		assertThat(sumPath.getSum(), is(11));
		assertThat(sumPath.getPath().toArray(new Integer[0]), equalTo(new Integer[]{1,3,7}));	
	}
	
	@Test
	public void maxSumPathBetweenTwoLeavesTest() {
		
	}
}
