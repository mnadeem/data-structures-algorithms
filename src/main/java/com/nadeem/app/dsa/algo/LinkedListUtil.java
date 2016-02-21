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

	public static <T extends Comparable<? super T>> LinearNode<T> rReverse(LinearNode<T> head) {
		if (head.getNext() == null) {
			return head;
		}
		LinearNode<T> newHead = rReverse(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);

		return newHead;
	}

	public static <T> LinearNode<T> merge(LinearNode<T> list1, LinearNode<T> list2) {
		LinearNode<T> curr1 = list1, curr2 = list2;
		LinearNode<T> next1, next2;
		
		while (curr1 != null && curr2 != null) {
			next1 = curr1.getNext();
			next2 = curr2.getNext();
			
			curr2.setNext(next1);
			curr1.setNext(curr2);
			
			curr1 = next1;
			curr2 = next2;					
		}	
		
		return curr2;
	}

	public static <T> LinearNode<T> middleNode(LinearNode<T> head) {
		LinearNode<T> curr= head, mid=head;
		int index = 0;

		while (curr != null) {
			++index;
			if (index%2 == 0) {
				mid = mid.getNext();
			}
			curr = curr.getNext();			
		}		
		return mid;
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
	/**
	 * 
	 * @see <a href="http://stackoverflow.com/questions/10275587/finding-loop-in-a-singly-linked-list">For Refrence</a>	 
	 */
	public static <T extends Comparable<? super T>> LinearNode<T> loopExists(LinearNode<T> head) {
		if (head == null || head.getNext() == null) {
			return null;
		}
		LinearNode<T> tortoise=head, hare = head.getNext();
		while(hare != null) {
			tortoise = tortoise.getNext();
			if(hare.getNext() == null) {
				return null;
			}
			hare = hare.getNext().getNext();

			if (hare == tortoise) {
				return hare;
			}
		}		
		return null;
	}

	public static<T extends Comparable<? super T>> void removeCycle(LinearNode<T> head, LinearNode<T> meetingPoint) {
		LinearNode<T> ptr1 = head;
		LinearNode<T> ptr2 = meetingPoint;
		while (ptr1 != ptr2.getNext()) {
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext();
		}
		ptr2.setNext(null);
	}


}
