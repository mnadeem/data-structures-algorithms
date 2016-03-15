package com.nadeem.app.dsa.adt;

import java.util.List;

public interface Trie {

    boolean contains(String word);  
    void insert(String word);
    boolean remove(String word);    
    int frequency(String word);
    List<TrieEntry> getAll();

	public class TrieEntry {
		public String word;
		public int frequency;
		public TrieEntry(String word, int frequency) {
			this.word = word;
			this.frequency = frequency;
		}

		@Override
		public String toString() {
			return String.format("TrieEntry [word=%s, frequency=%d]", word, frequency);
		}
	}
}
