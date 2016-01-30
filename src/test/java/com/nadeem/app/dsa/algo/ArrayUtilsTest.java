package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ArrayUtilsTest {
	private Integer[] seed;

	@Before
	public void doBeforeEachTestCase() {
		this.seed = new Integer[]{1,2,3,4,5,6,7,8};
	}

	@Test
	public void wholeArrayReverse() {
		ArrayUtils.<Integer>reverse(seed);
		assertThat(seed[0], is(8));
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
		assertThat((Integer)result[0], is(4));
		assertThat((Integer)result[7], is(3));
		
	}
	
	@Test
	public void mutableRotationTest() {
		int numberOfPositions = 3;
		ArrayUtils.<Integer>mutableRotate(seed, numberOfPositions);
		assertThat(seed[0], is(4));
		assertThat(seed[7], is(3));
	}
}
