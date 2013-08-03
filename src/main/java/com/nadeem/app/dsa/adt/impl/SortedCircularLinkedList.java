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
		if (shouldInsertDataAsHead()) {
			this.head = new Node<E>(element);
			this.head.next = head;			
		} else if (shouldInsertDataBeforeHead(element)) {
			Node<E> newNode = new Node<E>(element);
			Node<E> concernedNode = lastNode();
			newNode.next = this.head;
			concernedNode.next = newNode;
			this.head = newNode;			
		} else {
			Node<E> newNode = new Node<E>(element);
			Node<E> concernedNode = getConcernedNode(element);
			newNode.next = concernedNode.next;
			concernedNode.next = newNode;
		}
		this.count++;
		return true;
	}

	private Node<E> getConcernedNode(E element) {
		Node<E> currentNode = this.head;
		while (currentNode.next != this.head && currentNode.next.data.compareTo(element) < 0) {
			currentNode = currentNode.next;			
		}
		return currentNode;
	}

	private boolean shouldInsertDataAsHead() {
		return null == this.head;
	}

	private boolean shouldInsertDataBeforeHead(E element) {
		return this.head.data.compareTo(element) > 0;
	}

	private Node<E> lastNode() {
		Node<E> currentNode = this.head;
		while (currentNode.next != this.head) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	public int size() {
		return this.count;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public boolean contains(E element) {
		throw new UnsupportedOperationException();
	}

	public boolean remove(E element) {
		throw new UnsupportedOperationException();
	}

	public boolean removeFirst() {
		throw new UnsupportedOperationException();
	}

	public boolean removeLast() {
		throw new UnsupportedOperationException();
	}

	public Iterator<E> getIterator() {
		return new CircularLinkedListIterator(this.head);
	}

	private class CircularLinkedListIterator implements Iterator<E> {
		private Node<E> currentNode;

		public CircularLinkedListIterator(Node<E> newCurrentNode) {
			this.currentNode = newCurrentNode;
		}

		public E current() {
			if (this.currentNode == null) {
				return null;
			}
			return this.currentNode.data;
		}

		public void next() {
			this.currentNode = this.currentNode.next;			
		}

		public boolean isDone() {
			return this.currentNode == head;
		}

		public void first() {
			throw new UnsupportedOperationException();
		}

		public void last() {
			throw new UnsupportedOperationException();			
		}

		public void previous() {
			throw new UnsupportedOperationException();			
		}		
	}
}
