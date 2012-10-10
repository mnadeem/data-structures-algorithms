package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.exception.EmptyCollectionException;

public class ArrayStackTest {
	
	private Stack<String> arrayStack;

	@Before
	public void doBeforeEachTestCase() {
		arrayStack = new ArrayStack<String>();
	}

	@Test
	public void sizeShouldBeOneAfterPush() {
		
		arrayStack.push("A");
		assertThat(arrayStack.size(), is(1));
	}

	@Test
	public void sizeShouldBeTwoAfterTwoPushes() {
		arrayStack.push("A");
		arrayStack.push("B");
		assertThat(arrayStack.size(), is(2));
	}

	@Test
	public void capacityShouldBeIncreased() throws Exception {
		for (int i = 0; i < 101; i++) {
			arrayStack.push(String.valueOf(i));
		}
		assertThat(arrayStack.size(), greaterThan(100));
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void popThrowsExceptionIfEmptyCollection() throws Exception {
		arrayStack.pop();
	}
	
	@Test
	public void poppedElementIsA() throws Exception {
		arrayStack.push("A");
		assertThat(arrayStack.pop(), is("A"));
	}
}
