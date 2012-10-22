package com.nadeem.app.dsa.adt;

import com.nadeem.app.dsa.exception.CollectionEmptyException;

public class DropOutStack<T> implements Stack<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private T elements[];
	private int top;
	private int count;

	public DropOutStack() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public DropOutStack(int size) {
		assert size > 0;
		this.elements 	= ((T[]) new Object[size]);
		this.top 		= 0;
		this.count 		= 0;
	}

	public void push(T element) {
		this.elements[top] = element;
		this.top = (this.top + 1) % this.elements.length;
		if (this.count != this.elements.length) {
			this.count ++;
		}
	}

	public T pop() {
		if (isEmpty()) {
			throw new CollectionEmptyException();
		}
		this.top = (this.top + this.elements.length - 1) % this.elements.length;
		T result = this.elements[this.top];
		this.elements[this.top] = null;
		
		this.count --;
		return result;
	}

	public int size() {
		return this.count;
	}

	public T peek() {
		return this.elements[this.top - 1];
	}

	public boolean isEmpty() {
		return this.count == 0;
	}
}
