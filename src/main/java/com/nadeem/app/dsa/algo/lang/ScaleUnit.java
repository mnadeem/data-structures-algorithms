package com.nadeem.app.dsa.algo.lang;

public class ScaleUnit {
	private int exponent;
	private String names[];
	public ScaleUnit(int exponent, String... names) {
		this.exponent = exponent;
		this.names = names;
	}
	
	public String getName(int index) {
		return this.names[index];
	}

	public int getExponent() {
		return exponent;
	}

}
