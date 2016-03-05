package com.nadeem.app.dsa.algo.lang.processor;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.algo.lang.Scale;

public class CompositeBigProcessorTest {

	private AbstractProcessor processor;

	@Before
	public void doBeforeEachTestCase() {
		this.processor = new CompositeBigProcessor(6, Scale.SHORT);
	}
	
	@Test
	public void onesTest() {
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
	}
	
	@Test
	public void tensTest() {
		assertThat(this.processor.getName(20), equalTo("twenty"));
		assertThat(this.processor.getName(21), equalTo("twenty-one"));
		assertThat(this.processor.getName(22), equalTo("twenty-two"));
		assertThat(this.processor.getName(23), equalTo("twenty-three"));
		assertThat(this.processor.getName(24), equalTo("twenty-four"));
		assertThat(this.processor.getName(25), equalTo("twenty-five"));
		assertThat(this.processor.getName(26), equalTo("twenty-six"));
		assertThat(this.processor.getName(27), equalTo("twenty-seven"));
		assertThat(this.processor.getName(28), equalTo("twenty-eight"));
		assertThat(this.processor.getName(29), equalTo("twenty-nine"));
		assertThat(this.processor.getName(30), equalTo("thirty"));
		assertThat(this.processor.getName(33), equalTo("thirty-three"));
		assertThat(this.processor.getName(40), equalTo("fourty"));
		assertThat(this.processor.getName(44), equalTo("fourty-four"));
		assertThat(this.processor.getName(50), equalTo("fifty"));
		assertThat(this.processor.getName(60), equalTo("sixty"));
		assertThat(this.processor.getName(70), equalTo("seventy"));
		assertThat(this.processor.getName(80), equalTo("eighty"));
		assertThat(this.processor.getName(90), equalTo("ninety"));
		assertThat(this.processor.getName(99), equalTo("ninety-nine"));		
	}
	
	@Test
	public void hundredTest() {

		assertThat(this.processor.getName(100), equalTo("one hundred"));
		assertThat(this.processor.getName(201), equalTo("two hundred one"));
		assertThat(this.processor.getName(999), equalTo("nine hundred ninety-nine"));
	}
	
	@Test
	public void ThousandtTest() {

		assertThat(this.processor.getName(1100), equalTo("one thousand one hundred"));
		assertThat(this.processor.getName(1201), equalTo("one thousand two hundred one"));
		assertThat(this.processor.getName(1999), equalTo("one thousand nine hundred ninety-nine"));
		
		
		assertThat(this.processor.getName(9009), equalTo("nine thousand nine"));
		assertThat(this.processor.getName(19009), equalTo("nineteen thousand nine"));
		assertThat(this.processor.getName(219009), equalTo("two hundred nineteen thousand nine"));
	}
}
