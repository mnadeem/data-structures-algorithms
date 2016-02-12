package com.nadeem.app.dsa.algo;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
}
