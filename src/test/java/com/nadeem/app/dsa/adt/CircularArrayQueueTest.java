package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.exception.CollectionEmptyException;
import com.nadeem.app.dsa.exception.CollectionFullException;

public class CircularArrayQueueTest {
	
	private Queue<String> queue;

	@Before
	public void doBeforeEachTestCase() {
		queue = new CircularArrayQueue<String>();
	}

	@Test
	public void enqueueShouldBeSucessfull() throws Exception {
		queue.enqueue("A");
		assertThat(queue.size(), is(1));
	}
	
	@Test(expected=CollectionFullException.class)
	public void enqueueShouldThrowExceptionAfterMaxElements() throws Exception {
		for (int i = 0; i < 51; i++) {
			queue.enqueue(String.valueOf(i));
		}
	}
	
	@Test
	public void queueShouldNotBeEmpty() throws Exception {
		queue.enqueue("A");
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void dequeueShouldBeSucessFull() throws Exception {
		queue.enqueue("A");
		assertThat(queue.dequeue(), is("A"));
	}
	
	@Test(expected=CollectionEmptyException.class)
	public void dequeueSholdThrowExceptionOnEmptyCollection() throws Exception {
		queue.dequeue();
	}
}
