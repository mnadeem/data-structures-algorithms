package com.nadeem.app.dsa.adt;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.adt.impl.SortedCircularLinkedList;

public class SortedCircularLinkedListTest {
	
	private SortedCircularLinkedList<Integer> linkedList;

	@Before
	public void doBeforeEachTestCase() {
		this.linkedList = new SortedCircularLinkedList<Integer>();
	}

	@Test
	public void isInstanceOfOrderedList() {		
		assertThat(this.linkedList).isInstanceOf(OrderedList.class);
	}

	@Test
	public void listIsEmpty() throws Exception {
		assertThat(this.linkedList.size()).isEqualTo(0);
	}
}
