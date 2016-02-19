package com.nadeem.app.dsa.support;

public class MutableInteger {
	private Integer value;
	
	public MutableInteger(Integer val) {
		this.value = val;
	}

	public boolean updateIfLess(Integer newValue) {
		if (this.value < newValue) {
			this.value = newValue;
			return true;
		}
		return false;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
