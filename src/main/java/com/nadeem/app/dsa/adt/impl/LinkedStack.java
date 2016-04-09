package com.nadeem.app.dsa.adt.impl;

import com.nadeem.app.dsa.adt.Stack;
import com.nadeem.app.dsa.exception.CollectionEmptyException;
import com.nadeem.app.dsa.support.LinearNode;

public class LinkedStack<T extends Comparable<? super T>> implements Stack<T> {

	private LinearNode<T> top;
	private int count;

	public LinkedStack() {
		this.top 	= null;
		this.count 	= 0;
	}

	public final void push(final T newElement) {
		LinearNode<T> temp = new LinearNode<T>(newElement);
		temp.next(this.top);
		this.top = temp;
		this.count++;
	}

	public final T pop() {
		if (this.isEmpty()) {
			throw new CollectionEmptyException();
		}
		T result = this.top.getData();
		this.top = this.top.next();
		this.count--;
		return result;
	}

	public final int size() {
		return this.count;
	}

	public final T peek() {
		if (this.isEmpty()) {
			throw new CollectionEmptyException();
		}
		return this.top.getData();
	}

	public final boolean isEmpty() {
		return this.count == 0;
	}
}
