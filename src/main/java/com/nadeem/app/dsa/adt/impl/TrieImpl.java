package com.nadeem.app.dsa.adt.impl;

import java.util.HashMap;
import java.util.Map;

import com.nadeem.app.dsa.adt.Trie;

public class TrieImpl implements Trie {
	
	private Node root;
	
	public TrieImpl() {
		this.root = new Node();
	}

	@Override
	public String bestMatch(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(String word) {
		this.root.add(word);
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private static class Node {
		private Character value;
		private Map<Character, Node> children;
		private Node parent;
		private boolean isWord;
		
		public Node() {
			this.children = new HashMap<Character, Node>();
			this.isWord = false;
		}
		
		public Node (Character chr, Node parent) {
			this();
			this.value = chr;
			this.parent = parent;
		}

		public Character getValue() {
			return value;
		}

		public void add(String word) {
			char charAt = word.charAt(0);
			if (!this.children.containsKey(charAt)) {
				Node temp = new Node(charAt, parent);
				this.children.put(charAt, temp);
			}

			if (word.length() > 1) {
				this.children.get(charAt).add(word.substring(1));
			} else {
				this.isWord = true;
			}
		}		
	}
}
