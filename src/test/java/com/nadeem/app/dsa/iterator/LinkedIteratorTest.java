package com.nadeem.app.dsa.iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.support.LinearNode;

public class LinkedIteratorTest {
	private Iterator<String> linkedIterator;
	
	@Before
	public void doBeforeEachTestCase() {
		
	}

	@Test
	public void isDoneIsTrue() {
		this.linkedIterator = new LinkedIterator<String> (null);
		assertThat(this.linkedIterator.isDone(), is(true));
	}
	
	@Test
	public void isDoneIsFalse() throws Exception {
		this.linkedIterator = new LinkedIterator<String>(new LinearNode<String>());
		assertThat(this.linkedIterator.isDone(), is(false));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void lastShouldThrowUnSupportedOperationException() throws Exception {
		this.linkedIterator = new LinkedIterator<String>(new LinearNode<String>());
		this.linkedIterator.last();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void previousShouldThrowUnSupportedOperationException() throws Exception {
		this.linkedIterator = new LinkedIterator<String>(new LinearNode<String>());
		this.linkedIterator.previous();
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void firstShouldThrowUnSupportedOperationException() throws Exception {
		this.linkedIterator = new LinkedIterator<String>(new LinearNode<String>());
		this.linkedIterator.first();
	}
}
