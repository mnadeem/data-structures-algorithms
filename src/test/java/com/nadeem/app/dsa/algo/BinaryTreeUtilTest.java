package com.nadeem.app.dsa.algo;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

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

}
