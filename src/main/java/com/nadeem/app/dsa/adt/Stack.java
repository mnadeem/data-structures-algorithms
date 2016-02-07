package com.nadeem.app.dsa.adt;

public interface Stack<T extends Comparable<? super T>> {

	void push(T element);
	T pop();
	int size();
	T peek();
	boolean isEmpty();
}
