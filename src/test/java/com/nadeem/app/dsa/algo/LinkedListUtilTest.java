package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.nadeem.app.dsa.support.LinearNode;
import com.nadeem.app.dsa.support.MultiNode;
import com.nadeem.app.dsa.support.RandomLinearNode;

public class LinkedListUtilTest {

	@Test
	public void reverseLinkedList() {
		LinearNode<Integer> head = buildLinkedList(1,2,3,4);
		head = LinkedListUtil.reverse(head);
		assertLinkedList(head, 4,3,2,1);
	}
	
	@Test
	public void rReverseLinkedList() {
		LinearNode<Integer> head = buildLinkedList(1,2,3,4);
		head = LinkedListUtil.rReverse(head);
		assertLinkedList(head, 4,3,2,1);
	}

	@Test
	public void mergeAlternateNodesTest() {
		LinearNode<Integer> list1 = buildLinkedList(1,2,3,4);
		LinearNode<Integer> list2 = buildLinkedList(5,6,7,8);
		list2 = LinkedListUtil.mergeAlternatively(list1, list2);
		assertLinkedList(list1, 1,5,2,6,3,7,4,8);
		assertNull(list2);	
	}

	@Test
	public void findMiddleNode() {
		LinearNode<Integer> list = buildLinkedList(1,2,3,4);
		LinearNode<Integer> mid = LinkedListUtil.middleNode(list);
		assertThat(mid.getData(), is(3));
		mid = LinkedListUtil.middleNode(buildLinkedList(1,2,3,4,5));
		assertThat(mid.getData(), is(3));
	}
	
	@Test
	public void foldLinkedList() {
		LinearNode<Integer> head = buildLinkedList(1,2,3,4,5,6,7,8);
		head = LinkedListUtil.fold(head);
		assertLinkedList(head, 1,8,2,7,3,6,4,5);
	}

	@Test
	public void linkedListLengthTest() {
		LinearNode<Integer> list = buildLinkedList(9,2,3,4);
		int length = LinkedListUtil.length(list);
		assertThat(length, is(4));
	}
	
	@Test
	public void reverseAlternateKNodes() {
		LinearNode<Integer> head = buildLinkedList(1,2,3,4,5,6,7,8,9,10);
		head = LinkedListUtil.reverseAlternateKNodes(head, 3);
		assertLinkedList(head, 3,2,1,4,5,6,9,8,7,10);
	}
	
	@Test
	public void mergeSortedLists() {
		LinearNode<Integer> l1 = buildLinkedList(1,4,8,10);
		LinearNode<Integer> l2 = buildLinkedList(2,3,5,6,9);
		l1 = LinkedListUtil.mergeSorted(l1, l2);
		
		assertLinkedList(l1, 1,2,3,4,5,6,8,9,10);
	}
	
	@Test
	public void linkedListSumTest() {
		LinearNode<Integer> ll1 = buildLinkedList(9,2,3,4);
		LinearNode<Integer> ll2 = buildLinkedList(8,3,4);
		
		LinearNode<Integer> result = LinkedListUtil.sum(ll1, ll2);
		printLinkedList(result);
	}

	@Test
	public void loopTest () {
		LinearNode<Integer> head = buildLinkedList(true);
		LinearNode<Integer> meetingPoint = LinkedListUtil.<Integer>loopExists(head);
		assertNotNull(meetingPoint);
		
		LinearNode<Integer> cycle = LinkedListUtil.removeCycle(head, meetingPoint);
		
		assertThat(cycle.getData(), equalTo(6));

		meetingPoint = LinkedListUtil.<Integer>loopExists(head);
		assertNull(meetingPoint);
	}
	
	@Test
	public void flattenListTest() {
		MultiNode<Integer> multiList = buildMultiList();
		MultiNode<Integer> result = LinkedListUtil.flatten(multiList);
		assertMultiList(result, 5, 7, 8, 10, 19, 20, 22, 28, 30, 35, 40, 45, 50);
	}
	
	@Test
	public void seperateEvenAndOddNodesTest() {
		LinearNode<Integer> head = buildLinkedList(2,3,4,1,7,8,9);
		head = LinkedListUtil.seperateEvenAndOddNodes(head);
		assertLinkedList(head, 2,4,8,3,1,7,9);

		head = buildLinkedList(9,3,4,1,7,8,2);
		head = LinkedListUtil.seperateEvenAndOddNodes(head);
		assertLinkedList(head, 4,8,2,9,3,1,7);
		
		head = buildLinkedList(1,3,5,7);
		head = LinkedListUtil.seperateEvenAndOddNodes(head);
		assertLinkedList(head, 1,3,5,7);
		
		head = buildLinkedList(2,4,6,8);
		head = LinkedListUtil.seperateEvenAndOddNodes(head);
		assertLinkedList(head, 2,4,6,8);
	}
	
	
	@Test
	public void seperateEvenAndOddIndexesTest() {
		LinearNode<Integer> head = buildLinkedList(1,2,3,4,5,6);
		head = LinkedListUtil.seperateEvenAndOddIndexNodes(head);
		assertLinkedList(head, 1,3,5,2,4,6);

		head = buildLinkedList(1);
		head = LinkedListUtil.seperateEvenAndOddIndexNodes(head);
		assertLinkedList(head, 1);
		
		head = buildLinkedList(1, 2);
		head = LinkedListUtil.seperateEvenAndOddIndexNodes(head);
		assertLinkedList(head, 1, 2);
		
		head = buildLinkedList(1, 2, 3);
		head = LinkedListUtil.seperateEvenAndOddIndexNodes(head);
		assertLinkedList(head, 1, 3, 2);
	}
	
	@Test
	public void cloneLinkeListWithRandomPointerTest() {
		RandomLinearNode<Integer> one = new RandomLinearNode<Integer>(1, null, null);
		RandomLinearNode<Integer> two = new RandomLinearNode<Integer>(2, one, null);
		RandomLinearNode<Integer> three = new RandomLinearNode<Integer>(3, two, null);
		RandomLinearNode<Integer> four = new RandomLinearNode<Integer>(4, three, null);
		RandomLinearNode<Integer> five = new RandomLinearNode<Integer>(5, four, four);
		RandomLinearNode<Integer> six = new RandomLinearNode<Integer>(6, five, two);
		RandomLinearNode<Integer> seven = new RandomLinearNode<Integer>(7, six, three);
		RandomLinearNode<Integer> eight = new RandomLinearNode<Integer>(8, seven, one);
		
		RandomLinearNode<Integer> newHead = LinkedListUtil.clone(eight);
		assertThat(eight, not(sameInstance(newHead)));
		assertThat(newHead.getElement(), equalTo(eight.getElement()));
		assertThat(newHead.random().getElement(), equalTo(eight.random().getElement()));
		
		assertThat(newHead.next().getElement(), equalTo(eight.next().getElement()));
		assertThat(newHead.next().random().getElement(), equalTo(eight.next().random().getElement()));
		
		assertThat(newHead.next().next().getElement(), equalTo(eight.next().next().getElement()));
		assertThat(newHead.next().next().random().getElement(), equalTo(eight.next().next().random().getElement()));
		
		
		assertThat(newHead.next().next().next().getElement(), equalTo(eight.next().next().next().getElement()));
		assertThat(newHead.next().next().next().random().getElement(), equalTo(eight.next().next().next().random().getElement()));
	}
	
	@Test
	public void sortLinkedListOf0s1sAnd2sTest() {
		LinearNode<Integer> head = buildLinkedList(2,1,0,2,1,0,0,1);
		head = LinkedListUtil.sortLinkedListOf0s1sAnd2s(head);
		assertLinkedList(head, 0,0,0,1,1,1,2,2);
		
		head = buildLinkedList(0,0,0,0);
		head = LinkedListUtil.sortLinkedListOf0s1sAnd2s(head);
		assertLinkedList(head, 0,0,0,0);
		
		head = buildLinkedList(1,1,1,1);
		head = LinkedListUtil.sortLinkedListOf0s1sAnd2s(head);
		assertLinkedList(head, 1,1,1,1);
		
		head = buildLinkedList(2,2,2,2);
		head = LinkedListUtil.sortLinkedListOf0s1sAnd2s(head);
		assertLinkedList(head, 2,2,2,2);
		
		head = buildLinkedList(1,2,1,2,1);
		head = LinkedListUtil.sortLinkedListOf0s1sAnd2s(head);
		assertLinkedList(head, 1,1,1,2,2);
		
		head = buildLinkedList(2,1,1,2,1);
		head = LinkedListUtil.sortLinkedListOf0s1sAnd2s(head);
		assertLinkedList(head, 1,1,1,2,2);
		
		head = buildLinkedList(0,2,0,2,0);
		head = LinkedListUtil.sortLinkedListOf0s1sAnd2s(head);
		assertLinkedList(head, 0,0,0,2,2);
		
		head = buildLinkedList(2,0,0,2,0);
		head = LinkedListUtil.sortLinkedListOf0s1sAnd2s(head);
		assertLinkedList(head, 0,0,0,2,2);
	}
	
	private void assertMultiList(MultiNode<Integer> result, int... arr) {
		for (int i : arr) {
			assertThat(result.data(), is(i));
			result = result.down();
		}
	}
	/**
	 * 
	 * This will create the following structure
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
     */
	private MultiNode<Integer> buildMultiList() {
		MultiNode<Integer> n45 = new MultiNode<Integer>(45);
		MultiNode<Integer> n40 = new MultiNode<Integer>(40, n45);
		MultiNode<Integer> n35 = new MultiNode<Integer>(35, n40);
		MultiNode<Integer> n28 = new MultiNode<Integer>(28, n35);

		MultiNode<Integer> n50 = new MultiNode<Integer>(50);
		MultiNode<Integer> n22 = new MultiNode<Integer>(22, n50);
		MultiNode<Integer> n19 = new MultiNode<Integer>(19, n22);
		n19.right(n28);
		
		
		MultiNode<Integer> n20 = new MultiNode<Integer>(20);
		MultiNode<Integer> n10 = new MultiNode<Integer>(10, n20);
		n10.right(n19);
		
		MultiNode<Integer> n30 = new MultiNode<Integer>(30);
		MultiNode<Integer> n8 = new MultiNode<Integer>(8, n30);
		MultiNode<Integer> n7 = new MultiNode<Integer>(7, n8);
		MultiNode<Integer> n5 = new MultiNode<Integer>(5, n7);
		n5.right(n10);

		return n5;
	}

	private static void printLinkedList(LinearNode<Integer> head) {
		LinearNode<Integer> current = head;
		while(current != null) {
			System.out.println(String.format("%d ", current.getData()));
			current = current.next();
		}
		
	}

	private LinearNode<Integer> buildLinkedList(int... items) {
		LinearNode<Integer> previous = new LinearNode<Integer>(items[0]);
		LinearNode<Integer> head = previous;
		for (int i = 1; i < items.length; i++) {
			previous.next(new LinearNode<Integer>(items[i]));
			previous = previous.next();
		}
		return head;
	}
	
	private <T extends Comparable<? super T>>  void assertLinkedList(LinearNode<T> node, T... arr) {
		for (int i = 0; i < arr.length; i++) {
			assertThat(node.getData(), is(arr[i]));
			node = node.next();
		}		
	}

	private LinearNode<Integer> buildLinkedList(boolean cycle) {
		
		LinearNode<Integer> node6 = new LinearNode<Integer>(6);		
		LinearNode<Integer> node5 = new LinearNode<Integer>(5, node6);
		LinearNode<Integer> node4 = new LinearNode<Integer>(4, node5);
		LinearNode<Integer> node3 = new LinearNode<Integer>(3, node4);
		LinearNode<Integer> node2 = new LinearNode<Integer>(2, node3);
		LinearNode<Integer> node1 = new LinearNode<Integer>(1, node2);
		LinearNode<Integer> head = new LinearNode<Integer>(0, node1);

		if (cycle) {
			node6.next(node3);
		}
		return head;
	}
}
