package com.nadeem.app.dsa.algo.lang.processor;

public abstract class AbstractProcessor {

	protected static final String SEPERATOR = " ";
	protected static final int NO_VALUE = -1;

	public String getName(double value ) {
		return getName(Double.toString(value));
	}

	public String getName(long  value) {
		return getName(Long.toString(value));
	}

	public abstract String getName(String name); 
}
