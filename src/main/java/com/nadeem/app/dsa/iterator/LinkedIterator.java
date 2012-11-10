package com.nadeem.app.dsa.iterator;

import com.nadeem.app.dsa.support.LinearNode;

public class LinkedIterator<T> implements Iterator<T> {
	
	private LinearNode<T> current;

	public LinkedIterator(final LinearNode<T> head) {
		this.current = head;
	}

	public void first() {
		// TODO Auto-generated method stub
		
	}

	public T current() {
		// TODO Auto-generated method stub
		return null;
	}

	public void next() {
		// TODO Auto-generated method stub
		
	}

	public boolean isDone() {
		return this.current == null;
	}

	public void last() {
		throw new UnsupportedOperationException();
		
	}

	public void previous() {
		throw new UnsupportedOperationException();
	}
}
