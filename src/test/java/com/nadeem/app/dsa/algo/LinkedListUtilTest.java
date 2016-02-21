package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.nadeem.app.dsa.support.LinearNode;

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
		list2 = LinkedListUtil.merge(list1, list2);
		assertLinkedList(list1, 1,5,2,6,3,7,4,8);
		assertNull(list2);	
	}

	@Test
	public void findMiddleNode() {
		LinearNode<Integer> list = buildLinkedList(1,2,3,4);
		LinearNode<Integer> mid = LinkedListUtil.middleNode(list);
		assertThat(mid.getElement(), is(3));
		mid = LinkedListUtil.middleNode(buildLinkedList(1,2,3,4,5));
		assertThat(mid.getElement(), is(3));
	}
	
	private <T extends Comparable<? super T>>  void assertLinkedList(LinearNode<T> node, T... arr) {
		for (int i = 0; i < arr.length; i++) {
			assertThat(node.getElement(), is(arr[i]));
			node = node.getNext();
		}		
	}

	private static void printLinkedList(LinearNode<Integer> head) {
		LinearNode<Integer> current = head;
		while(current != null) {
			System.out.println(String.format("%d ", current.getElement()));
			current = current.getNext();
		}
		
	}

	private LinearNode<Integer> buildLinkedList(int... items) {
		LinearNode<Integer> previous = new LinearNode<Integer>(items[0]);
		LinearNode<Integer> head = previous;
		for (int i = 1; i < items.length; i++) {
			previous.setNext(new LinearNode<Integer>(items[i]));
			previous = previous.getNext();
		}
		return head;
	}
	
	@Test
	public void linkedListLengthTest() {
		LinearNode<Integer> list = buildLinkedList(9,2,3,4);
		int length = LinkedListUtil.length(list);
		assertThat(length, is(4));
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
		
		LinkedListUtil.removeCycle(head, meetingPoint);

		meetingPoint = LinkedListUtil.<Integer>loopExists(head);
		assertNull(meetingPoint);
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
			node6.setNext(node3);
		}
		return head;
	}
}
