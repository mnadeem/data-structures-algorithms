package com.nadeem.app.dsa.support;

public class LinearNode<T> {

	private T element;
	private LinearNode<T> next;

	public LinearNode() {

	}

	public LinearNode(final T newElement) {
		this.element = newElement;
	}

	public LinearNode(final T newElement, final LinearNode<T> newNext) {
		this.element = newElement;
		this.next = newNext;
	}

	public final T getElement() {
		return this.element;
	}

	public final LinearNode<T> getNext() {
		return this.next;
	}
}
