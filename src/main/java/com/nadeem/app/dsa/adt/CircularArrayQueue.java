package com.nadeem.app.dsa.adt;

import com.nadeem.app.dsa.exception.CollectionEmptyException;
import com.nadeem.app.dsa.exception.CollectionFullException;

public class CircularArrayQueue<T> implements Queue<T> {

	private final int DEFAULT_CAPACITY = 50;
	private T[] elements;
	private int front;
	private int rare;
	private int count;

	@SuppressWarnings("unchecked")
	public CircularArrayQueue() {
		this.elements = (T[]) new Object[DEFAULT_CAPACITY];
		this.count 	= 0;
		this.front 	= 0;
		this.rare 	= 0;
	}

	public final void enqueue(final T element) {
		if (this.elements.length == this.count) {
			throw new CollectionFullException();
		}
		this.elements[this.rare] = element;
		this.rare = (this.rare + 1) % this.elements.length;
		this.count++;
	}

	public final int size() {
		return this.count;
	}

	public final T dequeue() {
		if (this.isEmpty()) {
			throw new CollectionEmptyException();
		}
		T result = this.elements[this.front];
		this.front = (front + 1) % this.elements.length;
		this.count--;
		return result;
	}

	public final boolean isEmpty() {
		return this.size() == 0;
	}
}
