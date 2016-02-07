package com.nadeem.app.dsa.adt;


public interface Queue<T extends Comparable<? super T>> {
	void enqueue(T element);
	int size();
	T dequeue();
	boolean isEmpty();
}
