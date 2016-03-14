package com.nadeem.app.dsa.adt.impl;

import java.util.HashMap;
import java.util.Map;

import com.nadeem.app.dsa.adt.Trie;

public class TrieImpl implements Trie {
	
	private Node root;
	private int size = 0;
	
	public TrieImpl() {
		this.root = new Node();
	}

	@Override
	public boolean contains(String word) {
		Node node = root.search(word);				
		return node != null ? node.isWord : false;
	}

	@Override
	public void insert(String word) {
		this.root.add(word);
	}
	
	public int frequency(String word) {
		Node  node = root.search(word);
		return node != null ? node.frequency :  0;
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}
	
	private static class Node {
		private Character value;
		private Map<Character, Node> children;
		private boolean isWord;
		private int frequency;

		public Node() {
			this.children = new HashMap<Character, Node>();
			this.isWord = false;
		}
		
		public Node (Character chr) {
			this();
			this.value = chr;
		}

		Character getValue() {
			return value;
		}
		Node get(char key) {
			return this.children.get(key);
		}

		void add(String word) {
			char charAt = word.charAt(0);
			if (!this.children.containsKey(charAt)) {
				Node temp = new Node(charAt);
				this.children.put(charAt, temp);
			}

			if (word.length() > 1) {
				this.get(charAt).add(word.substring(1));
			} else {
				this.get(charAt).isWord= true;
				this.get(charAt).frequency++;				
			}
		}
		Node search(String word) {
			Node node = this;
			for (int i = 0; i < word.length(); i++) {
				if (node.children.containsKey(word.charAt(i))) {					
					node = node.get(word.charAt(i));
				} 
			}
			return node;
		}

		@Override
		public String toString() {
			return String.valueOf(getValue());
		}
	}
}
