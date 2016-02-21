package com.nadeem.app.dsa.support;

import static org.junit.Assert.*;

import org.junit.Test;


public class LinearNodeTest {
	
	@Test
	public void dataShouldBeNull() {
		LinearNode<String> node = new LinearNode<String>();
		assertNull(node.getElement());
	}

	@Test
	public void dataShouldNotBeNull() {
		LinearNode<String> node = new LinearNode<String>("A");
		assertNotNull(node.getElement());
	}
	
	@Test
	public void nextShouldBeNull() {
		LinearNode<String> node = new LinearNode<String>("A");
		assertNull(node.next());
	}
	
	@Test
	public void nextShouldNotBeNull() {
		LinearNode<String> node = new LinearNode<String>("A", new LinearNode<String>("B"));
		assertNotNull(node.next());
	}
}
