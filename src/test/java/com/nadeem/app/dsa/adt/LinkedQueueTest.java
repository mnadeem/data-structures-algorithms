package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.adt.impl.LinkedQueue;
import com.nadeem.app.dsa.exception.CollectionEmptyException;

public class LinkedQueueTest {
	
	private Queue<String> queue;

	@Before
	public void doBeforeEachTestCase() {
		queue = new LinkedQueue<String>();
	}
	
	@Test
	public void queueShouldBeEmpty() throws Exception {
		assertThat(queue.size(), is(0));
	}

	@Test
	public void shouldSuccessfullyEnqueue() {
		queue.enqueue("A");
		assertThat(queue.size(), is(1));
		
		queue.enqueue("B");
		assertThat(queue.size(), is(2));
	}

	@Test(expected= CollectionEmptyException.class)
	public void dequeueThrowsExceptionOnEmptyQueue() throws Exception {
		queue.dequeue();
	}
	
	@Test
	public void dequeuedElementIsA() throws Exception {
		queue.enqueue("A");
		assertThat(queue.dequeue(), is("A"));
	}

}
