package com.nadeem.app.dsa.algo;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void constructFromPostOrder() {
		Integer[] seed = new Integer[]{2,5,3,9,11,12,10,7};
		BinarySearchTree<Integer> bst = BinarySearchTree.<Integer>fromPostOrder(seed);
		bst.printInOrder(System.out);
		System.out.println();
		bst.printPreOrder(System.out);
	}

}
