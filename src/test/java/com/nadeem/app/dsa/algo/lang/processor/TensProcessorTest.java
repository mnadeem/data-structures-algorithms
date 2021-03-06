package com.nadeem.app.dsa.algo.lang.processor;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TensProcessorTest {

	private AbstractProcessor processor;
	
	@Before
	public void doBeforeEachTestCase() {
		this.processor = new TensProcessor();
	}

	@Test
	public void test() {
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
		assertThat(this.processor.getName(199), equalTo("ninety-nine"));
		assertThat(this.processor.getName(999), equalTo("ninety-nine"));
		
	}
}
