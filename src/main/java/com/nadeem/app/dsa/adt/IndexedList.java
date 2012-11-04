package com.nadeem.app.dsa.adt;

public interface IndexedList<E> extends List<E> {

	boolean add(int index, E element);
	boolean set(int index, E element);
	E get(int index);
	int indexOf(E element);
	E remove(int index);
}
