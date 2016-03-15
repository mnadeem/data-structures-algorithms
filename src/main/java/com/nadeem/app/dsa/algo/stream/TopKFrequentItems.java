package com.nadeem.app.dsa.algo.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.nadeem.app.dsa.adt.Trie;
import com.nadeem.app.dsa.adt.Trie.TrieEntry;
import com.nadeem.app.dsa.adt.impl.TrieImpl;

public class TopKFrequentItems {

	private int maxSize;

	private Trie trie = new TrieImpl();
	private PriorityQueue<TrieEntry> maxHeap;

	public TopKFrequentItems(int k) {
		this.maxSize = k;
		this.maxHeap = new PriorityQueue<TrieEntry>(k, maxHeapComparator());
	}

	private Comparator<TrieEntry> maxHeapComparator() {
		return new Comparator<TrieEntry>() {
			@Override
			public int compare(TrieEntry o1, TrieEntry o2) {
				return o1.frequency - o2.frequency;
			}			
		};
	}

	public void add(String word) {
		this.trie.insert(word);
	}

	public List<TopK> getItems() {
		
		for (TrieEntry trieEntry : this.trie.getAll()) {
			if (this.maxHeap.size() < this.maxSize) {
				this.maxHeap.add(trieEntry);
			} else if (this.maxHeap.peek().frequency < trieEntry.frequency) {
				this.maxHeap.remove();
				this.maxHeap.add(trieEntry);
			}
		}
		List<TopK> result = new ArrayList<TopK>();
		for (TrieEntry entry : this.maxHeap) {
			result.add(new TopK(entry));
		}		
		return result;
	}

	public static class TopK {
		public String item;
		public int frequency;
		
		public TopK(String item, int frequency) {
			this.item = item;
			this.frequency = frequency;
		}
		public TopK(TrieEntry entry) {
			this(entry.word, entry.frequency);
		}
		@Override
		public String toString() {
			return String.format("TopK [item=%s, frequency=%s]", item, frequency);
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + frequency;
			result = prime * result + ((item == null) ? 0 : item.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TopK other = (TopK) obj;
			if (frequency != other.frequency)
				return false;
			if (item == null) {
				if (other.item != null)
					return false;
			} else if (!item.equals(other.item))
				return false;
			return true;
		}
		
	}	
}
