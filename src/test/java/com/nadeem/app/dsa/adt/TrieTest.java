package com.nadeem.app.dsa.adt;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.nadeem.app.dsa.adt.Trie.TrieEntry;
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
		trie.insert("cotton");
		assertThat(trie.frequency("cot"), equalTo(2));
		assertThat(trie.frequency("cop"), equalTo(1));
		assertThat(trie.frequency("map"), equalTo(1));
		assertThat(trie.frequency("woo"), equalTo(0));
		for (TrieEntry item : trie.getAll()) {
			System.out.println(item);
		}		
	}
}
