package com.nadeem.app.dsa.iterator;

import com.nadeem.app.dsa.support.LinearNode;

public class LinkedIterator<T> implements Iterator<T> {

	private LinearNode<T> currentNode;

	public LinkedIterator(final LinearNode<T> head) {
		this.currentNode = head;
	}

	public final T current() {
		return this.currentNode.getElement();
	}

	public final void next() {
		this.currentNode = this.currentNode.next();
	}

	public final boolean isDone() {
		return this.currentNode == null;
	}

	public final void last() {
		throw new UnsupportedOperationException();
	}

	public final void previous() {
		throw new UnsupportedOperationException();
	}

	public final void first() {
		throw new UnsupportedOperationException();
	}
}
