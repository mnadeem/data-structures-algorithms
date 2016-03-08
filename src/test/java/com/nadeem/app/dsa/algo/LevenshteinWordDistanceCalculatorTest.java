package com.nadeem.app.dsa.algo;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.*;

public class LevenshteinWordDistanceCalculatorTest {

	private MELevenshteinWordDistanceCalculator calculator;

	@Before
	public void doBeforeEachTestCase() {
		this.calculator = MELevenshteinWordDistanceCalculator.DEFAULT;
	}

	@Test
	public void testEmptyToEmpty() {
		assertDistance(0, "", "");
	}
	@Test
	public void testEmptyToNonEmpty() {
		String target = "any";
		assertDistance(target.length(), "", target);
	}
	@Test
	public void testSamePrefix() {
		assertDistance(3, "unzip", "undo");
	}
	@Test
	public void testSameSuffix() {
		assertDistance(4, "eating", "running");
	}

	@Test
	public void testArbitrary() {
		assertDistance(3, "msteak", "mistake");
		assertDistance(3, "necassery", "neccessary");
		assertDistance(5, "donkey", "mule");
	}

	private void assertDistance(int distance, String source, String target) {
		assertThat(calculator.calculate(source, target), equalTo(distance));
		assertThat(calculator.calculate(target, source), equalTo(distance));
	}

}
