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

	public static <T> T[] immutableRotate(T[] seed, int numberOfPositions) {
		int length = seed.length;
		@SuppressWarnings("unchecked")
		T[] result =  (T[]) new Object[length];
		for (int i = 0; i < seed.length; i++) {
			result[i] = seed[(i+numberOfPositions)%length];
		}
		return result;
	}

	public static <T>  void mutableRotate(T[] seed, int numberOfPositions) {
		reverse(seed, 0, numberOfPositions);
		reverse(seed, numberOfPositions, seed.length);
		reverse(seed, 0, seed.length);
	}
	
	
}
