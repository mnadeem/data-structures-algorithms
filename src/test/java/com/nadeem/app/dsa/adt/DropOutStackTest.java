package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.dsa.exception.CollectionEmptyException;

public class DropOutStackTest {
	
	private Stack<String> dropOutStack;
	@Before
	public void doBeforeEachTestCase() {
		this.dropOutStack = new DropOutStack<String>(3);
	}

	@Test
	public void shouldPushSucessfully() {
		this.dropOutStack.push("A");
		assertThat(this.dropOutStack.size(), is(1));
	}

	@Test
	public void shouldRemoveLastElementIfNoPlace() throws Exception {
		this.dropOutStack.push("A");
		this.dropOutStack.push("B");
		assertThat(this.dropOutStack.size(), is(2));
		this.dropOutStack.push("C");
		assertThat(this.dropOutStack.size(), is(3));
	}

	@Test(expected = CollectionEmptyException.class)
	public void shouldThrowCollectionEmptyException() throws Exception {
		this.dropOutStack.pop();
	}
	
	@Test
	public void peekShouldReturnElementA() throws Exception {
		this.dropOutStack.push("A");
		assertThat(this.dropOutStack.peek(), is("A"));
	}
	
	@Test
	public void poppedElementIsA() throws Exception {
		this.dropOutStack.push("A");
		assertThat(this.dropOutStack.pop(), is("A"));
	}
	@Test
	public void poppedElementIsD() throws Exception {
		this.dropOutStack.push("A");
		this.dropOutStack.push("B");
		this.dropOutStack.push("C");
		this.dropOutStack.push("D");
		assertThat(this.dropOutStack.pop(), is("D"));
	}
	
	@Test
	public void fullBlownTest() throws Exception {
		this.dropOutStack.push("A");
		this.dropOutStack.push("B");
		this.dropOutStack.push("C");
		assertThat(this.dropOutStack.size(), is(3));
		this.dropOutStack.push("D");
		assertThat(this.dropOutStack.pop(), is("D"));
		assertThat(this.dropOutStack.pop(), is("C"));
	}
}
