package com.nadeem.app.dsa.adt;

import com.nadeem.app.dsa.exception.CollectionEmptyException;
import com.nadeem.app.dsa.support.LinearNode;

public class CircularLinkedQueue<T extends Comparable<? super T>> implements Queue<T> {
	
	private LinearNode<T> rear;
	private int count;
	
	public CircularLinkedQueue() {
		this.count = 0;
	}
	
	@Override
	public void enqueue(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);
		if (this.rear == null) {
			this.rear = temp;
			this.rear.next(this.rear);
		} else {
			temp.next(this.rear.next());
			this.rear.next(temp);
		}
		this.rear =this.rear.next();
		this.count ++;
	}

	@Override
	public int size() {
		return this.count;
	}

	@Override
	public T dequeue() {
		LinearNode<T> item;
		if (isEmpty()) {
			throw new CollectionEmptyException();
		} else if (this.rear == rear.next()) {
			item = this.rear;
			this.rear = null;
		} else {
			item = rear.next();
			this.rear.next(item.next());
		}
		this.count --;
		return item.getElement();
	}

	@Override
	public boolean isEmpty() {
		return this.rear == null;
	}
}
