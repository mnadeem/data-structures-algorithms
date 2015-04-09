package com.nadeem.app.dsa.adt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.adt.impl.SortedCircularLinkedList;
import com.nadeem.app.dsa.iterator.Iterator;

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

		Iterator<Integer> iterator = this.linkedList.getIterator();
		assertThat(iterator.current()).isEqualTo(1);
		iterator.next();
		assertThat(iterator.isDone()).isTrue();
	}

	@Test
	public void shouldSuccessfullyAddElementBeforeHead() throws Exception {
		this.linkedList.add(4);
		this.linkedList.add(3);
		assertThat(this.linkedList.size()).isEqualTo(2);

		Iterator<Integer> iterator = this.linkedList.getIterator();
		assertThat(iterator.current()).isEqualTo(3);
		iterator.next();
		assertThat(iterator.isDone()).isFalse();
		assertThat(iterator.current()).isEqualTo(4);
		iterator.next();
		assertThat(iterator.isDone()).isTrue();
	}
	
	@Test
	public void shouldAddElementAfterHead() throws Exception {
		this.linkedList.add(3);
		this.linkedList.add(4);
		assertThat(this.linkedList.size()).isEqualTo(2);

		Iterator<Integer> iterator = this.linkedList.getIterator();
		assertThat(iterator.current()).isEqualTo(3);
		iterator.next();
		assertThat(iterator.isDone()).isFalse();
		assertThat(iterator.current()).isEqualTo(4);
		iterator.next();
		assertThat(iterator.isDone()).isTrue();
	}

	@Test
	public void iterate() throws Exception {
		this.linkedList.add(6);
		this.linkedList.add(8);
		this.linkedList.add(10);
		this.linkedList.add(12);
		this.linkedList.add(11);

		Iterator<Integer> iterator = this.linkedList.getIterator();
		do {
			System.out.println(iterator.current());
			iterator.next();
		}while(!iterator.isDone());
	}	
}
