package com.nadeem.app.dsa.adt;


public interface Queue<T> {

	public void enqueue(T element);

	public int size();

	public T dequeue();

}
