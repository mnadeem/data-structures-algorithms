package com.nadeem.app.dsa.adt;

import java.util.Arrays;

import com.nadeem.app.dsa.exception.EmptyCollectionException;

public class ArrayStack<T> implements Stack<T> {
	
	private final int DEFAULT_CAPACITY = 100;

	private int top;	
	private T[] elements;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		elements	= (T[]) new Object[DEFAULT_CAPACITY];
		top 		= 0;
	}

	public void push(T element) {
		if (this.size() == elements.length) {
			expandCapacity();
		}
		elements[top] = element;
		top++;
	}

	private void expandCapacity() {
		int newLength = elements.length * 2;
		elements = Arrays.copyOf(elements, newLength);
	}

	public int size() {
		return top;
	}

	public T pop() {
		if (size() == 0) {
			throw new EmptyCollectionException();
		}
		top--;
		T result = elements[top];
		elements[top] = null;
		return result;
	}
}
