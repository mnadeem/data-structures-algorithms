package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.nadeem.app.dsa.adt.impl.TrieImpl;

public class TrieTest {

	@Test
	public void addTest() {
		Trie trie = new TrieImpl();
		trie.insert("cot");
		trie.insert("cop");
		assertThat(trie.contains("cot"), equalTo(true));
		assertThat(trie.contains("cop"), equalTo(true));
		assertThat(trie.contains("cou"), equalTo(false));
	}
	
	@Test
	public void frequencyTest() {
		Trie trie = new TrieImpl();
		trie.insert("cot");
		trie.insert("cot");
		trie.insert("map");
		trie.insert("cop");
		assertThat(trie.frequency("cot"), equalTo(2));
		assertThat(trie.frequency("cop"), equalTo(1));
		assertThat(trie.frequency("map"), equalTo(1));
		assertThat(trie.frequency("woo"), equalTo(0));
		
	}

}
