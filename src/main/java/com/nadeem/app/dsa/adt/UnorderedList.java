package com.nadeem.app.dsa.adt;

public interface UnorderedList<E extends Comparable<E>> extends List<E> {
	boolean addToFron(E element);
	boolean addToRear(E element);
	boolean addAfter(E element);
	boolean addBefore(E element);
}
