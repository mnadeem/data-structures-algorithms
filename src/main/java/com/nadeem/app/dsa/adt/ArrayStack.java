package com.nadeem.app.dsa.adt;

import java.util.Arrays;

import com.nadeem.app.dsa.exception.EmptyCollectionException;

public class ArrayStack<T> implements Stack<T> {

	private final int DEFAULT_CAPACITY = 100;

	private int top;
	private T[] elements;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		this.elements	= (T[]) new Object[DEFAULT_CAPACITY];
		this.top 		= 0;
	}

	public void push(T element) {
		if (this.size() == this.elements.length) {
			expandCapacity();
		}
		this.elements[this.top] = element;
		this.top++;
	}

	private void expandCapacity() {
		int newLength = this.elements.length * 2;
		this.elements = Arrays.copyOf(this.elements, newLength);
	}

	public int size() {
		return this.top;
	}

	public T pop() {
		if (this.size() == 0) {
			throw new EmptyCollectionException();
		}
		this.top--;
		T result = this.elements[this.top];
		this.elements[this.top] = null;
		this.collapseCapacity();
		return result;
	}

	private void collapseCapacity() {
		int halfCapacity = this.elements.length >>> 1;
		if (this.top < halfCapacity) {
			this.elements = Arrays.copyOf(this.elements, halfCapacity);
		}
	}
}
