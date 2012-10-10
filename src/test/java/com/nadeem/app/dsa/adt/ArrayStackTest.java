package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ArrayStackTest {

	@Test
	public void sizeShouldBeOneAfterPush() {
		Stack<String> arrayStack = new ArrayStack<String>();
		arrayStack.push("A");
		assertThat(arrayStack.size(), is(1));
	}

	@Test
	public void sizeShouldBeTwoAfterTwoPushes() {
		Stack<String> arrayStack = new ArrayStack<String>();
		arrayStack.push("A");
		arrayStack.push("B");
		assertThat(arrayStack.size(), is(2));
	}

	@Test
	public void capacityShouldBeIncreased() throws Exception {
		Stack<String> arrayStack = new ArrayStack<String>();
		for (int i = 0; i < 101; i++) {
			arrayStack.push(String.valueOf(i));
		}
		assertThat(arrayStack.size(), greaterThan(100));
	}

}
