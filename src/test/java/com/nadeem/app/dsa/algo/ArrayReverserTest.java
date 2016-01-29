package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ArrayReverserTest {
	private Integer[] seed;

	@Before
	public void doBeforeEachTestCase() {
		this.seed = new Integer[]{1,2,3,4,5,6,7,8};
	}

	@Test
	public void wholeArrayReverse() {
		ArrayReverser.<Integer>reverse(seed);
		assertThat(seed[0], is(8));
	}

	@Test
	public void partialArrayReverse() {
		ArrayReverser.<Integer>reverse(seed, 1, 5);
		assertThat(seed[1], is(5));
	}
}
