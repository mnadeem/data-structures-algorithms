package com.nadeem.app.dsa.support;

public class RandomLinearNode<T> {
	
	private T element;
	private RandomLinearNode<T> next;
	private RandomLinearNode<T> random;
	
	public RandomLinearNode(final T newElement) {
		this.element 	= newElement;
	}

	public RandomLinearNode(final T newElement, final RandomLinearNode<T> newNext, RandomLinearNode<T> random) {
		this.element 	= newElement;
		this.next 		= newNext;
		this.random = random;
	}

	public RandomLinearNode<T> random() {
		return random;
	}

	public void random(RandomLinearNode<T> random) {
		this.random = random;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public RandomLinearNode<T> next() {
		return next;
	}

	public void next(RandomLinearNode<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.element);
	}

}
