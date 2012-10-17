package com.nadeem.app.dsa.adt;

import com.nadeem.app.dsa.exception.CollectionEmptyException;
import com.nadeem.app.dsa.support.LinearNode;

public class LinkedQueue<T> implements Queue<T> {

	private int count;
	private LinearNode<T> front, rear;

	public LinkedQueue() {
		this.count = 0;
		this.front = this.rear = null;
	}

	public final void enqueue(final T newElement) {
		LinearNode<T> temp = new LinearNode<T>(newElement);

		if (this.isEmpty()) {
			front = temp;
		} else {
			this.rear.setNext(temp);
		}

		this.rear = temp;
		this.count++;
	}

	public final boolean isEmpty() {
		return this.size() == 0;
	}

	public final int size() {
		return this.count;
	}

	public final T dequeue() {
		if (isEmpty()) {
			throw new CollectionEmptyException();
		}
		T result = this.front.getElement();
		this.front = this.front.getNext();
		this.count--;
		if (isEmpty()) {
			this.rear = null;
		}
		return result;
	}
}
