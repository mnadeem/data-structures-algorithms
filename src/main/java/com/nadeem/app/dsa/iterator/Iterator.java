package com.nadeem.app.dsa.iterator;

public interface Iterator <T> {
	void first();
	void last();
	boolean isDone();
	void next();
	void previous();
	T current();
}
