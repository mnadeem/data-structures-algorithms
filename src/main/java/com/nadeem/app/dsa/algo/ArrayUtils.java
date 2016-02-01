package com.nadeem.app.dsa.algo;

import java.util.logging.Logger;

public final class ArrayUtils {
	private static final Logger LOGGER = Logger.getLogger(ArrayUtils.class.getName());

	private ArrayUtils () {

	}

	public static <T extends Comparable<? super T>> void reverse(T[] seed) {
		reverse(seed, 0, seed.length);
	}

	public static <T extends Comparable<? super T>> void reverse(T[] seed, int startIndexInclusive, int endIndexExclusive) {
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

	private static <T extends Comparable<? super T>> void swap(T[] seed, int firstIndex, int secondIndex) {
		T temp =  seed[firstIndex];
		seed[firstIndex] = seed[secondIndex];
		seed[secondIndex] = temp;
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

	public static <T extends Comparable<? super T>>  void mutableRotate(T[] seed, int numberOfPositions) {
		reverse(seed, 0, numberOfPositions);
		reverse(seed, numberOfPositions, seed.length);
		reverse(seed, 0, seed.length);
	}

	public static <T> void mutableRotateMinSwap(T[] seed, int numberOfPositions) {

		for (int setIndex = 0; setIndex < MathUtil.iGCD(seed.length, numberOfPositions); setIndex++) {
			swapElementsInSet(seed, numberOfPositions, setIndex);
		}		
	}

	private static <T> void swapElementsInSet(T[] seed, int numberOfPositions, int setIndex) {
		int length = seed.length;
		T temp = seed[setIndex];
		int firstIncrementor = setIndex;
		int secondIncrementor;
		while(true) {
			secondIncrementor = firstIncrementor + numberOfPositions;
			if(secondIncrementor >= length) {
				secondIncrementor = secondIncrementor - length;
			}
			if (secondIncrementor == setIndex) {
				break;
			}				
			seed[firstIncrementor] = seed[secondIncrementor];
			firstIncrementor = secondIncrementor;
		}
		seed[firstIncrementor] = temp;
	}

	public static <T extends Comparable<? super T>> void mutableSelectionSort(T[] collection) {
		int endIndex = collection.length;
		for (int currentIndex = 0; currentIndex < endIndex; currentIndex++) {
			int minIndex = minIndex(collection, currentIndex, endIndex);
			if (currentIndex < minIndex) {
				swap(collection, currentIndex, minIndex);
			}
		}		
	}

	private static <T extends Comparable<? super T>> int minIndex(T[] collection, int startIndexInclusive, int endIndexExclusive) {
		int minIndex = startIndexInclusive;
		for (int i = startIndexInclusive + 1; i < endIndexExclusive; i++) {
			if (collection[i].compareTo(collection[minIndex]) < 0) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static <T extends Comparable<? super T>> void mutableBubbleSort(T[] collection) {
		int endIndex = collection.length - 1;
		for (int currentIteration = 0; currentIteration < endIndex; currentIteration++) {
			bubbleUp(collection, currentIteration, endIndex);
		}	
	}

	private static <T extends Comparable<? super T>> void bubbleUp(T[] collection, int currentIteration, int endIndex) {
		for (int currentIndex = endIndex; currentIndex > currentIteration; currentIndex--) {
			if(collection[currentIndex].compareTo(collection[currentIndex-1]) < 0) {
				swap(collection, currentIndex, currentIndex-1);
			}
		}
	}

	public static <T extends Comparable<? super T>> void mutableInsertionSort(T[] collection) {
		for (int index = 1; index < collection.length; index++)	{
			insert(collection, index);
		}		
	}

	private static <T extends Comparable<? super T>> void insert(T[] collection, int index) {
		T value = collection[index];
		int position = index;
		// Shift larger values to the right
		while (position > 0 && collection[position-1].compareTo(value) > 0)	{
			collection[position] = collection[position-1];
			position--;
		}
		collection[position] = value;//Insert into proper location
	}
}
