package com.nadeem.app.dsa.adt.impl;

import com.nadeem.app.dsa.adt.OrderedList;
import com.nadeem.app.dsa.iterator.Iterator;

public class SortedCircularLinkedList<E extends Comparable<E>> implements OrderedList<E> {

	private Node<E> head;
	private int count = 0;

	private static class Node<E> {
		private E data;
		private Node<E> next;
		public Node(E newData) {
			this.data = newData;
		}
	}

	public boolean add(E element) {
		if (null == head) {
			this.head = new Node<E>(element);
			this.head.next = head;
			this.count++;
		}
		return true;
	}

	public int size() {
		return this.count;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeFirst() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeLast() {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<E> getIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
