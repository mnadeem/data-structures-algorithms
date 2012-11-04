package com.nadeem.app.dsa.iterator;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayIteratorTest {

	private String[] elements;
	private Iterator<String> iterator;

	@Before
	public void doBeforeEachTest() {
		elements = new String[]{"a", "b", "c", "d", "e", "f"};
		iterator = new ArrayIterator<String>(elements);
	}

	@Test
	public void firstElementIsA() throws Exception {
		iterator.first();
		assertThat(iterator.current(), is("a"));
	}

	@Test
	public void lastElementIsF() throws Exception {
		iterator.last();
		assertThat(iterator.current(), is("f"));
	}

	@Test
	public void isDoneIsFlase() throws Exception {
		iterator.first();
		assertThat(iterator.isDone(), is(false));
	}
	
	@Test
	public void isDoneIsTrue() throws Exception {
		iterator.last();
		iterator.next();
		assertThat(iterator.isDone(), is(true));
	}
	
	@Test
	public void nextElementIsB() throws Exception {
		iterator.first();
		iterator.next();
		assertThat(iterator.current(), is("b"));
	}

	@Test
	public void iterationRespectBounds() {
		iterator.first();

		assertFalse(iterator.isDone());
		assertSame(elements[0], iterator.current());

		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(elements[1], iterator.current());

		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();

		assertTrue(iterator.isDone());

		try {
			iterator.current();
			fail();
		} catch (ArrayIndexOutOfBoundsException e) {
			// Expected
		}
	}

	@Test
	public void backwardIterationRespectBounds() throws Exception {
		iterator.last();

		assertFalse(iterator.isDone());

		assertSame(elements[elements.length-1], iterator.current());
		iterator.previous();
		iterator.previous();
		iterator.previous();
		iterator.previous();
		iterator.previous();
		iterator.previous();

		assertTrue(iterator.isDone());

		try {
			iterator.current();
			fail();
		} catch (ArrayIndexOutOfBoundsException e) {
			// Expected
		}
	}
}
