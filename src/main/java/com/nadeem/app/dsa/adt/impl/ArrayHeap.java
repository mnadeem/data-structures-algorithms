package com.nadeem.app.dsa.adt.impl;

import com.nadeem.app.dsa.adt.Queue;
import com.nadeem.app.dsa.exception.CollectionFullException;

public class ArrayHeap<T extends Comparable<? super T>> implements Queue<T> {

	private int lastIndex;
	private int maxIndex;
	private T[] elements;

	@SuppressWarnings("unchecked")
	public ArrayHeap(int maxSize) {
		this.maxIndex = maxSize - 1;
		this.lastIndex = -1;
		this.elements = (T[]) new Comparable[maxSize];
	}

	@Override
	public void enqueue(T element) {
		if (this.lastIndex == this.maxIndex) {
			throw new CollectionFullException();
		} else {
			this.lastIndex++;
			heapifyAdd(element);
		}		
	}

	private void heapifyAdd(T element) {
		int next = this.lastIndex;
		while(next > 0 && element.compareTo(parentOf(next)) > 0) {
			int parentIndex = parentIndex(next);
			this.elements[next] = this.elements[parentIndex];
			next = parentIndex;
		}
		this.elements[next] = element;
	}

	private T parentOf(int nodeIndex) {
		return this.elements[parentIndex(nodeIndex)];
	}

	private int parentIndex(int nodeIndex) {
		return (nodeIndex - 1)/2;
	}

	@Override
	public T dequeue() {
		return null;
	}

	@Override
	public int size() {
		return lastIndex + 1;
	}

	@Override
	public boolean isEmpty() {
		return lastIndex == -1;
	}

}
