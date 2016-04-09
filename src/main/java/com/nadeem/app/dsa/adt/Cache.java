package com.nadeem.app.dsa.adt;

public interface Cache <X, Y> {
	Y get(X key);
	void set(X key, Y value);
	void remove(X key);
	int size();
}
