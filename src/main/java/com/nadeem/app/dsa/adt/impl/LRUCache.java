package com.nadeem.app.dsa.adt.impl;

import java.util.HashMap;
import java.util.Map;

import com.nadeem.app.dsa.adt.Cache;
// Kind of linkedHashMap
public class LRUCache <K, V> implements Cache<K, V> {

	private int capacity;
	private Node<K, V> head, tail;
	private Map<K, Node<K, V>> map;

	private static final int DEFAULT_CAPACITY = 10;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<K, Node<K,V>>();
	}

	public LRUCache() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public V get(K key) {
		V result = null;
		Node<K, V> node = this.map.get(key);
		if (node != null) {
			result = node.value;
			remove(node);
			addAsHead(node);
		}
		return result;
	}

	@Override
	public void set(K key, V value) {
		Node<K, V> node = this.map.get(key);
		if (node == null) {
			Node<K, V> temp = new Node<K, V>(key, value);
			if (this.map.size() < this.capacity) {
				addAsHead(temp);
			} else {
				this.map.remove(this.tail.key);
				remove(this.tail);
				addAsHead(temp);
			}
			this.map.put(key, temp);
		} else {
			node.value = value;
			remove(node);
			addAsHead(node);
		}
	}

	private void remove(Node<K, V> node) {

		if (node.pre == null) {
			this.head = node.next;
		} else {
			node.pre.next = node.next;
		}
		
		if (node.next == null) {
			this.tail = node.pre;
		} else {
			node.next.pre = node.pre;
		}		
	}

	private void addAsHead(Node<K, V> node) {
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.head.pre = node;
			node.next = this.head;
			this.head = node;
		}
	}

	@Override
	public void remove(K key) {
		Node<K, V> node = this.map.get(key);
		if (node != null) {
			this.remove(node);
		}		
	}

	private static class Node <S, T> {
		public S key;
		public T value;
		Node<S, T> pre;
		Node<S, T> next;
		
		Node(S key, T value) {
			this.key = key;
			this.value = value;
		}		
	}

	@Override
	public int size() {
		return this.map.size();
	}
}
