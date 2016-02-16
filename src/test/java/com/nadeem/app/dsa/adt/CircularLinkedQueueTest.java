package com.nadeem.app.dsa.adt;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CircularLinkedQueueTest {

	@Test
	public void test() {
		Queue<Integer>  queue = new CircularLinkedQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertThat(queue.dequeue(), is(1));
		assertThat(queue.dequeue(), is(2));
		assertThat(queue.dequeue(), is(3));
		queue.enqueue(2);
		queue.enqueue(1);
		
		assertThat(queue.dequeue(), is(4));
		assertThat(queue.dequeue(), is(5));
	}

}
