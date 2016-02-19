package com.nadeem.app.dsa.support;

public class MutableValue <T> {
	private T value;
	
	public MutableValue(T val) {
		this.value = val;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
