package com.nadeem.app.dsa.support;

public class LinearNode<T> {

	public T data;
	public LinearNode<T> next;
	public LinearNode<T> prev;

	public LinearNode() {

	}

	public LinearNode(final T newElement) {
		this.data = newElement;
	}

	public LinearNode(final T newElement, final LinearNode<T> newNext) {
		this.data 	= newElement;
		this.next 		= newNext;
	}
	
	public LinearNode(final LinearNode<T> newPrev, final T newElement, final LinearNode<T> newNext) {
		this.data 	= newElement;
		this.next 		= newNext;
		this.prev 		= newPrev;
	}

	public final T getData() {
		return this.data;
	}

	public void setData(T element) {
		this.data = element;
	}

	public final LinearNode<T> next() {
		return this.next;
	}

	public void next(final LinearNode<T> next) {
		this.next = next;
	}

	public LinearNode<T> prev() {
		return prev;
	}

	public void prev(LinearNode<T> prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return String.valueOf(this.data);
	}
}
