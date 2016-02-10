package com.nadeem.app.dsa.adt;

public interface DisjointSets<T extends Comparable<? super T>> {
	T findRepresentative(T item);
	void union(T x, T y);
}
