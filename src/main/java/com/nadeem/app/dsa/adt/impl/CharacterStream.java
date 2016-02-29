package com.nadeem.app.dsa.adt.impl;

import rx.Observable;
import rx.functions.Action1;

public class CharacterStream {
	
	private static int  MAX_CHAR =  256;

	private Node<Character> head;
	private Node<Character> tail;

	private boolean[] repeated;//We can even use Bitset
	private Node<Character>[] inDLL;

	@SuppressWarnings("unchecked")
	public CharacterStream(final Observable<Character> inputStream) {
		
		repeated = new boolean[MAX_CHAR];
		inDLL = new Node[MAX_CHAR];
		for (int i = 0; i < MAX_CHAR; i++) {
			repeated[i] = false;
			inDLL[i] = null;
		}
		
		inputStream.subscribe(new Action1<Character>() {

			@Override
			public void call(Character incomingCharacter) {
				System.out.println("Received -> " + incomingCharacter);
				processStream(incomingCharacter);	
			}
		});
	}

	public Character firstNonRepeating() {
		if (head == null) {
			return null;
		}
		return head.item;
	}

	private void processStream(Character chr) {
		int charValue = (int) chr.charValue();
		if (!repeated[charValue]) {
			
			if (inDLL[charValue] == null) {
				appendToTail(chr);
				inDLL[charValue] = tail;
			} else {
				removeNode(inDLL[charValue]);
				inDLL[charValue] = null;
				repeated[charValue] = true;
			}
		}
	}

	private void removeNode(Node<Character> node) {
		if (head == null) {
			return ;
		} 
		
		if (head == node) {
			head = head.next;
			//head.prev = null;
		} 
		if (tail == node) {
			tail = tail.prev;
			//tail.next = null;
		}
		
		if (node.next != null) {
			node.next.prev= node.prev;
		}
		if (node.prev != null) {
			node.prev.next = node.next;
		}
	}

	private void appendToTail(Character chr) {
		Node<Character> temp = new Node<Character>(chr);
		if (head == null) {
			head = temp;
			tail = temp;
		}
		tail.next = temp;
		temp.prev = tail;
		tail = temp;
	}

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;
		public Node(E val) {
			this.item = val;
		}
	}
}
