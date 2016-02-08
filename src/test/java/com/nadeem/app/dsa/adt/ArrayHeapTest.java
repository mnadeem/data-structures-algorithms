package com.nadeem.app.dsa.adt;

import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.nadeem.app.dsa.adt.impl.ArrayHeap;

import mockit.Deencapsulation;

public class ArrayHeapTest {

	@Test
	public void enqueueTest() {
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(7);
		
		heap.enqueue(5);
		heap.enqueue(3);
		heap.enqueue(1);
		heap.enqueue(4);
		heap.enqueue(2);
		heap.enqueue(6);
		heap.enqueue(7);
		
		Comparable<Integer>[] result= Deencapsulation.<Integer[]>getField(heap, "elements");
		assertThat(result, equalTo(new Comparable[]{7,4,6,3,2,1,5}));
	}
	
	@Test
	public void dequeueTest() {
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(7);
		
		heap.enqueue(5);
		heap.enqueue(3);
		heap.enqueue(1);
		heap.enqueue(4);
		heap.enqueue(2);
		heap.enqueue(6);
		heap.enqueue(7);
		
		assertThat(heap.dequeue(), is(7));
		assertThat(heap.dequeue(), is(6));
		assertThat(heap.dequeue(), is(5));
		assertThat(heap.dequeue(), is(4));
		assertThat(heap.dequeue(), is(3));
		assertThat(heap.dequeue(), is(2));
		assertThat(heap.dequeue(), is(1));
	}

}
