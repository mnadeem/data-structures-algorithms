package com.nadeem.app.dsa.iterator;

public class ArrayIterator<T> implements Iterator<T> {

	private T[] elements;
	private int startIndex;
	private int endIndex;
	private int currentIndex;

	public ArrayIterator(T[] newElements) {
		this(newElements, 0,  newElements.length - 1);
	}

	public ArrayIterator(T[] newElements, int start, int end) {
		this.elements 		= newElements;
		this.startIndex 	= start;
		this.endIndex 		= end;
		this.currentIndex 	= this.startIndex;
	}

	public void first() {
		this.currentIndex = this.startIndex;
	}

	public void last() {
		this.currentIndex =  this.endIndex;
	}

	public boolean isDone() {
		return this.currentIndex > this.endIndex || this.currentIndex < this.startIndex;
	}

	public void next() {
		this.currentIndex ++;
	}

	public void previous() {
		this.currentIndex--;
	}

	public T current() {
		if (isDone()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return this.elements[this.currentIndex];
	}
}
