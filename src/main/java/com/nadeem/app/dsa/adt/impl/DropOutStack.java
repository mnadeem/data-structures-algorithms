package com.nadeem.app.dsa.adt.impl;

import com.nadeem.app.dsa.adt.Stack;
import com.nadeem.app.dsa.exception.CollectionEmptyException;

public class DropOutStack<T> implements Stack<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private final T[] elements;
	private int top;
	private int count;

	public DropOutStack() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public DropOutStack(final int size) {
		assert size > 0;
		this.elements 	= ((T[]) new Object[size]);
		this.top 		= 0;
		this.count 		= 0;
	}

	public final void push(final T element) {
		this.elements[top] = element;
		this.top = (this.top + 1) % this.elements.length;
		if (this.count != this.elements.length) {
			this.count++;
		}
	}

	public final T pop() {
		if (isEmpty()) {
			throw new CollectionEmptyException();
		}
		this.top = (this.top + this.elements.length - 1) % this.elements.length;
		T result = this.elements[this.top];
		this.elements[this.top] = null;

		this.count--;
		return result;
	}

	public final int size() {
		return this.count;
	}

	public final T peek() {
		return this.elements[this.top - 1];
	}

	public final boolean isEmpty() {
		return this.count == 0;
	}
}
