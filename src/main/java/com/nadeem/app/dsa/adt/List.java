package com.nadeem.app.dsa.adt;

import java.util.Iterator;

public interface List<E> extends Iterator<E> {

	int size();
	boolean isEmpty();
	boolean contains(E element);

	boolean rempve(E element);
	boolean removeFirst();
	boolean removeLast();

	E first();
	E last();
}
