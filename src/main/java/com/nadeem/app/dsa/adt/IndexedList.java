package com.nadeem.app.dsa.adt;

public interface IndexedList<E extends Comparable<E>> extends List<E> {

	boolean add(E element, int index);
	boolean set(E element, int index);
	E get(int index);
	int indexOf(E element);
	E remove(int index);
}
