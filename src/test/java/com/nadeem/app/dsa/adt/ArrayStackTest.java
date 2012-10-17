package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.exception.CollectionEmptyException;

public class ArrayStackTest {

	private Stack<String> arrayStack;

	@Before
	public void doBeforeEachTestCase() {
		this.arrayStack = new ArrayStack<String>();
	}

	@Test
	public void sizeShouldBeOneAfterPush() {
		
		this.arrayStack.push("A");
		assertThat(this.arrayStack.size(), is(1));
	}

	@Test
	public void sizeShouldBeTwoAfterTwoPushes() {
		this.arrayStack.push("A");
		this.arrayStack.push("B");
		assertThat(this.arrayStack.size(), is(2));
	}

	@Test
	public void capacityShouldBeIncreased() throws Exception {
		for (int i = 0; i < 101; i++) {
			this.arrayStack.push(String.valueOf(i));
		}
		assertThat(arrayStack.size(), greaterThan(100));
	}
	
	@Test(expected=CollectionEmptyException.class)
	public void popThrowsExceptionIfEmptyCollection() throws Exception {
		this.arrayStack.pop();
	}
	
	@Test
	public void poppedElementIsA() throws Exception {
		this.arrayStack.push("A");
		assertThat(this.arrayStack.pop(), is("A"));
	}

	@Test
	public void capacityShouldBeDecreased() throws Exception {
		for (int i = 0; i < 101; i++) {
			this.arrayStack.push(String.valueOf(i));
		}
		assertThat(arrayStack.size(), greaterThan(100));
		this.arrayStack.pop();
		this.arrayStack.pop();
	}
	
	@Test(expected=CollectionEmptyException.class)
	public void peekThrowsExceptionIfEmptyCollection() throws Exception {
		this.arrayStack.peek();
	}
	@Test
	public void peekedElementIsA() throws Exception {
		this.arrayStack.push("A");
		assertThat(this.arrayStack.peek(), is("A"));
	}
}
