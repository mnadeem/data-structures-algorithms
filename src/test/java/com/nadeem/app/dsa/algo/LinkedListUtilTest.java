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
		printLinkedList(head);
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
