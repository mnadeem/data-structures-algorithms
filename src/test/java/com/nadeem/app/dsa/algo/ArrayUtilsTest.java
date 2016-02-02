package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ArrayUtilsTest {
	private Integer[] seed;

	@Before
	public void doBeforeEachTestCase() {
		this.seed = new Integer[]{4,2,3,1,5,8,7,6};
	}

	@Test
	public void wholeArrayReverse() {
		ArrayUtils.<Integer>reverse(seed);
		assertThat(seed[0], is(6));
	}

	@Test
	public void partialArrayReverse() {
		ArrayUtils.<Integer>reverse(seed, 1, 5);
		assertThat(seed[1], is(5));
	}

	@Test
	public void imMutableRotationTest() {
		int numberOfPositions = 3;
		Object[] result =  ArrayUtils.<Integer>immutableRotate(seed, numberOfPositions);
		assertThat((Integer)result[0], is(1));
		assertThat((Integer)result[7], is(3));
		
	}

	@Test
	public void mutableRotationTest() {
		int numberOfPositions = 3;
		ArrayUtils.<Integer>mutableRotate(seed, numberOfPositions);
		assertThat(seed[0], is(1));
		assertThat(seed[7], is(3));
	}

	@Test
	public void mutableRotationMinSwapTest() {
		int numberOfPositions = 3;
		ArrayUtils.<Integer>mutableRotateMinSwap(seed, numberOfPositions);
		assertThat(seed[0], is(1));
		assertThat(seed[7], is(3));
	}

	@Test
	public void selectionSortFirstTest() {
		ArrayUtils.<Integer>mutableSelectionSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));
	}

	@Test
	public void bubbleSortFirstTest() {
		ArrayUtils.<Integer>mutableBubbleSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));
	}

	@Test
	public void insertionSortFirstTest() {
		ArrayUtils.<Integer>mutableInsertionSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));
	}

	@Test
	public void shellSortFirstTest() {
		ArrayUtils.<Integer>mutableShellSort(seed);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(seed, equalTo(result));
	}

	@Test
	public void mergeArrayFirstTest() {
		Integer[] collection = new Integer[]{5,6,7,8,1,2,3,4};
		ArrayUtils.<Integer>mergeArray(collection, 0,3,7);
		Integer[] result = new Integer[]{1,2,3,4,5,6,7,8};
		assertThat(collection, equalTo(result));
	}
}
