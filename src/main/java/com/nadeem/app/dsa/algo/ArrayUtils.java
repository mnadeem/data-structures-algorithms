package com.nadeem.app.dsa.algo;

import java.util.logging.Logger;

public final class ArrayUtils {
	private static final Logger LOGGER = Logger.getLogger(ArrayUtils.class.getName());
	
	private ArrayUtils () {
		
	}
	
	public static <T> void reverse(T[] seed) {
		reverse(seed, 0, seed.length);
	}

	public static <T> void reverse(T[] seed, int startIndexInclusive, int endIndexExclusive) {
		if (seed == null || seed.length == 0) {
			LOGGER.warning("Nothing to rotate");
		}
		int start = startIndexInclusive < 0 ? 0 : startIndexInclusive;
		int end = Math.min(seed.length, endIndexExclusive) - 1;
		while (start < end) {
			swap(seed, start, end);
			start++;
			end--;
		}
	}

	private static <T> void swap(T[] seed, int start, int end) {
		T temp =  seed[start];
		seed[start] = seed[end];
		seed[end] = temp;
	}	
	
}
