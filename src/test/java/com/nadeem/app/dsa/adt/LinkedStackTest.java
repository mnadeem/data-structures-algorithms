package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.nadeem.app.dsa.exception.EmptyCollectionException;

public class LinkedStackTest {

	@Test
	public void shouldSuccessfullyPushAnElement() {
		Stack<String> stack = new LinkedStack<String>();
		stack.push("A");
		assertThat(stack.size(), greaterThan(0));
	}
	
	@Test
	public void shouldSuccessfullyPushThreeElements() {
		Stack<String> stack = new LinkedStack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		assertThat(stack.size(), is(3));
	}
	
	@Test
	public void shouldSuccessfullyPopThreeElements() {
		Stack<String> stack = new LinkedStack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		assertThat(stack.size(), is(3));
		assertThat(stack.pop(), is("C"));		
		assertThat(stack.size(), is(2));
		assertThat(stack.pop(), is("B"));		
		assertThat(stack.size(), is(1));
	}
	@Test(expected = EmptyCollectionException.class)
	public void shouldThrowExceptionWhilePoppingEmptyStack() throws Exception {
		Stack<String> stack = new LinkedStack<String>();
		stack.pop();
	}

	@Test(expected = EmptyCollectionException.class)
	public void shouldThrowExceptionWhilePeekingEmptyStack() throws Exception {
		Stack<String> stack = new LinkedStack<String>();
		stack.peek();
	}

	@Test
	public void peekedElementIsA() throws Exception {
		Stack<String> stack = new LinkedStack<String>();
		stack.push("A");
		assertThat(stack.peek(), is("A"));		
	}
}
