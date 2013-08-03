package com.nadeem.app.dsa.adt;

import com.nadeem.app.dsa.iterator.Iterator;

public interface List<E extends Comparable<E>> {

	int size();
	boolean isEmpty();
	boolean contains(E element);

	boolean remove(E element);
	boolean removeFirst();
	boolean removeLast();
	Iterator<E> getIterator();
}
