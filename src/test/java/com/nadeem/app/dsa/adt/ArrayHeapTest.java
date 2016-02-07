package com.nadeem.app.dsa.adt;

import org.junit.Test;

import com.nadeem.app.dsa.adt.impl.ArrayHeap;

public class ArrayHeapTest {

	@Test
	public void test() {
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(7);
		
		heap.enqueue(5);
		heap.enqueue(3);
		heap.enqueue(1);
		heap.enqueue(4);
		heap.enqueue(2);
		heap.enqueue(6);
		heap.enqueue(7);
	}

}
