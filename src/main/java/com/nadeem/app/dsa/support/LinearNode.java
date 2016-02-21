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
		this.element 	= newElement;
		this.next 		= newNext;
	}

	public final T getElement() {
		return this.element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public final LinearNode<T> next() {
		return this.next;
	}

	public void next(final LinearNode<T> next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return String.valueOf(this.element);
	}
}
