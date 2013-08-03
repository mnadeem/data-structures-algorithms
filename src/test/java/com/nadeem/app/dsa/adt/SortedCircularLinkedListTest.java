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
	public void listIsZero() throws Exception {
		assertThat(this.linkedList.size()).isEqualTo(0);
	}

	@Test
	public void listIsEmpty() throws Exception {
		assertThat(this.linkedList.isEmpty()).isTrue();
	}
	@Test
	public void shouldSuccessfullyAddElementAsHead() throws Exception {
		boolean added = this.linkedList.add(1);
		assertThat(added).isTrue();
		assertThat(this.linkedList.size()).isEqualTo(1);
	}
	@Test
	public void shouldSuccessfullyAddElementBeforeHead() throws Exception {
		this.linkedList.add(4);
		this.linkedList.add(3);
		assertThat(this.linkedList.size()).isEqualTo(2);
	}
	
}
