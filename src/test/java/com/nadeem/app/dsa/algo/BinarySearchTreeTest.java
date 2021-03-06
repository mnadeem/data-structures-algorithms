package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void constructFromPostOrder() {
		Integer[] seed = new Integer[]{2,5,3,9,11,12,10,7};
		List<Integer> result = new ArrayList<Integer>();
		BinarySearchTree<Integer> bst = BinarySearchTree.<Integer>fromPostOrder(seed);
		bst.printInOrder(result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{2, 3, 5, 7, 9, 10, 11, 12}));
		result.clear();
		bst.printPreOrder(result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{7, 3, 2, 5, 10, 9, 12, 11}));
		result.clear();
		bst.printPostOrder(result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{2, 5, 3, 9, 11, 12, 10, 7}));
		result.clear();
	}

	@Test
	public void constructFromPreAndNodeType() {
		BinarySearchTree<Integer> bst = BinarySearchTree.<Integer>fromPreAndNodeType(new Integer[]{10, 30, 20, 5, 15}, new char[]{'N', 'N', 'L', 'L', 'L'});
		List<Integer> result = new ArrayList<Integer>();
		bst.printInOrder(result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{20, 30, 5, 10, 15}));
		result.clear();
		bst.printPreOrder(result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{10, 30, 20, 5, 15}));
		result.clear();
		bst.printPostOrder(result);
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{20, 5, 30, 15, 10}));
	}
}
