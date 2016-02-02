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
			shiftAndInsert(collection, 1, index);
		}		
	}

	static <T extends Comparable<? super T>> void insert(T[] collection, int index) {
		T value = collection[index];
		int position = index;
		// Shift larger values to the right
		while (position > 0 && collection[position-1].compareTo(value) > 0)	{
			collection[position] = collection[position-1];
			position--;
		}
		collection[position] = value;//Insert into proper location
	}

	public static <T extends Comparable<? super T>> void mutableShellSort(T[] collection) {
		int interval = 1;
		int length = collection.length;
		while (interval < length / 3) {
			interval = interval * 3 + 1;
		}
		while (interval > 0) {
			for (int outer = interval; outer < length; outer++) {
				shiftAndInsert(collection, interval, outer);
			}
			interval = (interval - 1)/3;
		}
	}

	private static <T extends Comparable<? super T>> void shiftAndInsert(T[] collection, int interval, int outer) {
		T value = collection[outer];
		int inner= outer;
		// Shift larger values to the right
		while(inner > 0  && collection[inner - interval].compareTo(value) > 0) {
			collection[inner]= collection[inner - interval];
			inner = inner- interval;
		}
		//insert the number at correct, whole position
		collection[inner] = value;
	}

	public static <T extends Comparable<? super T>> void merge(T[] collection, int low, int mid, int high) {
		T[] tmp = doMerge(collection, low, mid, high);
		copyResult(collection, tmp);
	}

	private static <T extends Comparable<? super T>>  void copyResult(T[] collection, T[] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			collection[i] = tmp[i];
		}
	}

	private static <T extends Comparable<? super T>> T[] doMerge(T[] collection, int low, int mid, int high) {
		int index = 0;
		int leftIndex = low;
		int rightIndex = mid + 1;
		@SuppressWarnings("unchecked")
		T[] tmp = (T[])new Comparable[high - low + 1];
		while(leftIndex <=mid || rightIndex <=high) {
			if(leftIndex > mid) {
				tmp[index++] = collection[rightIndex++];
			} else if(rightIndex > high) {
				tmp[index++] = collection[leftIndex++];
			} else	if (collection[leftIndex].compareTo(collection[rightIndex]) < 0) {
				tmp[index++]=collection[leftIndex++];
			} else {
				tmp[index++]=collection[rightIndex++];
			}
		}
		return tmp;
	}
	/**
	 * Refer this http://www.cs.nthu.edu.tw/~wkhon/algo08-tutorials/tutorial1b.pdf
	 * @param collection
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static <T extends Comparable<? super T>>  void inPlaceMerge(T[] collection, int low, int mid, int high) {
		int left = low;
		int right = mid + 1;
		
		if(collection[mid].equals(collection[right])) {
			return ;//Skip the merge if required
		}
		while (left <= mid && right <= high) {			
			// Select from left:  no change, just advance left
			if (collection[left].compareTo(collection[right]) <= 0) {
				left ++;
			} else { // Select from right:  rotate [left..right] and correct
				T tmp = collection[right]; // Will move to [left]
				rotateRight(collection, left, right - left);
				collection[left] = tmp;
				// EVERYTHING has moved up by one
				left ++; right ++; mid ++;
			}
		}		
	}

	private static <T extends Comparable<? super T>> void rotateRight(T[] collection, int left, int numberOfElements) {
		System.arraycopy(collection, left, collection, left+1, numberOfElements);		
	}
}
