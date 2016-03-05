package com.nadeem.app.dsa.algo.lang.processor;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class UnitProcessorTest {

	private AbstractProcessor processor;
	
	@Before
	public void doBeforeEachTestCase() {
		this.processor = new UnitProcessor();
	}

	@Test
	public void test() {
		assertThat(this.processor.getName(1), equalTo("one"));
		assertThat(this.processor.getName(2), equalTo("two"));
		assertThat(this.processor.getName(3), equalTo("three"));
		assertThat(this.processor.getName(4), equalTo("four"));
		assertThat(this.processor.getName(5), equalTo("five"));
		assertThat(this.processor.getName(6), equalTo("six"));
		assertThat(this.processor.getName(7), equalTo("seven"));
		assertThat(this.processor.getName(8), equalTo("eight"));
		assertThat(this.processor.getName(9), equalTo("nine"));
		assertThat(this.processor.getName(10), equalTo("ten"));
		assertThat(this.processor.getName(11), equalTo("eleven"));
		assertThat(this.processor.getName(19), equalTo("nineteen"));
		assertThat(this.processor.getName(119), equalTo("nineteen"));
		assertThat(this.processor.getName(11119), equalTo("nineteen"));
	}

}
