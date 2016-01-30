package com.nadeem.app.dsa.algo;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class MathUtilTest {

	@Test
	public void iterativeFirstTest() {
		int gcd = MathUtil.iGCD(6, 2);
		assertThat(gcd, is(2));
	}

	@Test
	public void iterativeSecondTest() {
		int gcd = MathUtil.iGCD(101, 99);
		assertThat(gcd, is(1));
	}

	@Test
	public void recursiveFirstTest() {
		int gcd = MathUtil.rGCD(6, 3);
		assertThat(gcd, is(3));
	}
	
	@Test
	public void recursiveSecondTest() {
		int gcd = MathUtil.rGCD(111, 109);
		assertThat(gcd, is(1));
	}
	
}
