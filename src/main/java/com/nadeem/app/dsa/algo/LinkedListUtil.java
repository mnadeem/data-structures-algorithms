package com.nadeem.app.dsa.algo;

import com.nadeem.app.dsa.support.LinearNode;

public class LinkedListUtil {

	public static<T> LinearNode<T> reverse(LinearNode<T> head) {
		LinearNode<T> current = head;
		LinearNode<T> previous = null;
		LinearNode<T> next = null;
		while(current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		return previous;
	}

	public static<T> LinearNode<Integer> sum(LinearNode<Integer> ll1, LinearNode<Integer> ll2) {
		if (ll1 == null) {
			return ll2;
		}
		if (ll2 == null) {
			return ll1;
		}
		int extraNodes = countDiff(ll1, ll2);
		LinearNode<Integer> result = null;
		Integer[] carry =  new Integer[1];
		
		if (extraNodes > 0) {
			result = doSum(ll1, null, extraNodes, carry,  ll1, ll2);
		} else if (extraNodes < 0) {
			result = doSum(null, ll2, extraNodes, carry,  ll1, ll2);
		} else {
			result = doSum(ll1, ll2, extraNodes, carry,  ll1, ll2);
		}
		
		if (carry[0] != 0) {
			LinearNode<Integer> temp= new LinearNode<Integer>(carry[0]);
			temp.setNext(result);
			result = temp;
		}

		return result;
	}

	private static <T> LinearNode<Integer> doSum(LinearNode<Integer> ll1, LinearNode<Integer> ll2, int extraNodes, Integer[] carry, LinearNode<Integer> head1, LinearNode<Integer> head2) {
		if (ll1 == null && ll2 == null) {
			carry[0]=0;
			return null;
		}
		LinearNode<Integer> nextNode = null;
		if (extraNodes > 0) {
			nextNode = doSum(ll1, null, extraNodes - 1, carry, head1, head2);
		} else if (extraNodes < 0) {
			nextNode = doSum(null, ll2, extraNodes + 1, carry, head1, head2);
		} else {
			LinearNode<Integer> ll1Next = ll1 == null ? head1 : ll1.getNext();
			LinearNode<Integer> ll2Next = ll2 == null ? head2 : ll2.getNext();
			nextNode = doSum(ll1Next, ll2Next, 0, carry, head1, head2);
		}
		
		int val1 = ll1 != null ? ll1.getElement() : 0;
		int val2 = ll2 != null ? ll2.getElement() : 0;
		
		int sum = (val1 +val2 + carry[0]) %10;
		carry[0] = (val1+ val2+carry[0])/10;

		LinearNode<Integer> temp = new LinearNode<Integer>(sum);
		temp.setNext(nextNode);

		return temp;
	}

	private static<T> int countDiff(LinearNode<T> ll1, LinearNode<T> ll2) {
		int ls1 = length(ll1);
		int ls2 = length(ll2);
		return ls1-ls2;
	}

	public static <T> int length(LinearNode<T> list) {
		int length = 0;
		while(list !=null) {
			length++;
			list= list.getNext();
		}
		return length;
	}

	public static <T extends Comparable<? super T>> boolean loopExists(LinearNode<T> head) {
		if (head == null || head.getNext() == null) {
			return false;
		}
		LinearNode<T> tortoise=head, hare = head.getNext();
		while(hare != null) {
			tortoise = tortoise.getNext();
			if(hare.getNext() == null) {
				return false;
			}
			hare = hare.getNext().getNext();

			if (hare == tortoise) {
				return true;
			}
		}		
		return false;
	}
}
