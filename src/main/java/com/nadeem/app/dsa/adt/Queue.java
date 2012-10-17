package com.nadeem.app.dsa.adt;


public interface Queue<T> {

	void enqueue(T element);
	int size();
	T dequeue();
	boolean isEmpty();
}
