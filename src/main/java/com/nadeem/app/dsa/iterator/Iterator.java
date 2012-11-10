package com.nadeem.app.dsa.iterator;

public interface Iterator <T> {
	void first();
	T current();
	void next();
	boolean isDone();
	void last();
	void previous();
}
