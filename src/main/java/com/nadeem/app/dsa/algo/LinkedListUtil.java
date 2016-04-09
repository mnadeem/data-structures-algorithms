package com.nadeem.app.dsa.algo;

import com.nadeem.app.dsa.support.LinearNode;
import com.nadeem.app.dsa.support.MultiNode;
import com.nadeem.app.dsa.support.RandomLinearNode;

public class LinkedListUtil {

	public static<T> LinearNode<T> reverse(LinearNode<T> head) {
		LinearNode<T> current = head;
		LinearNode<T> previous = null;
		LinearNode<T> next = null;
		while(current != null) {
			next = current.next();
			current.next(previous);
			previous = current;
			current = next;
		}
		return previous;
	}

	public static <T> LinearNode<T> rReverse(LinearNode<T> head) {
		if (head.next() == null) {
			return head;
		}
		LinearNode<T> newHead = rReverse(head.next());
		head.next().next(head);
		head.next(null);

		return newHead;
	}

	public static <T> LinearNode<T> mergeAlternatively(LinearNode<T> list1, LinearNode<T> list2) {
		LinearNode<T> curr1 = list1, curr2 = list2;
		LinearNode<T> next1, next2;

		while (curr1 != null && curr2 != null) {
			next1 = curr1.next();
			next2 = curr2.next();
			
			curr2.next(next1);
			curr1.next(curr2);
			
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
				mid = mid.next();
			}
			curr = curr.next();			
		}		
		return mid;
	}

	public static <T> int length(LinearNode<T> node) {
		int length = 0;
		while(node != null) {
			length++;
			node = node.next();
		}
		return length;
	}

	public static <T> LinearNode<T> reverseAlternateKNodes(LinearNode<T> node, int k) {
		int count = 0;
		LinearNode<T> curr=node, prev = null, next = null;
		//reverse k nodes
		while (curr != null && count < k) {
			next = curr.next();
			curr.next(prev);
			prev = curr;
			curr = next;
			count ++;
		}
		// head should point to start of next k node
		node.next(curr);
		// skip next knodes
		count = 0;
		while (curr != null && count < k- 1) {
			curr = curr.next();
			count ++;
		}
		// do it recursively
		if (curr != null) {			
			curr.next(reverseAlternateKNodes(curr.next(), k));
		}
		
		return prev;
	}

	/**
	 * 
	 * @see <a href="http://stackoverflow.com/questions/10275587/finding-loop-in-a-singly-linked-list">For Refrence</a>	 
	 */
	public static <T extends Comparable<? super T>> LinearNode<T> loopExists(LinearNode<T> head) {
		if (head == null || head.next() == null) {
			return null;
		}
		LinearNode<T> tortoise=head, hare = head.next();
		while(hare != null) {
			if (hare == tortoise) {
				return hare;
			}
			tortoise = tortoise.next();
			if(hare.next() == null) {
				return null;
			}
			hare = hare.next().next();
		}		
		return null;
	}

	public static<T extends Comparable<? super T>> LinearNode<T> removeCycle(LinearNode<T> head, LinearNode<T> meetingPoint) {
		LinearNode<T> ptr1 = head;
		LinearNode<T> ptr2 = meetingPoint;
		while (ptr1 != ptr2.next()) {
			ptr1 = ptr1.next();
			ptr2 = ptr2.next();
		}
		ptr2.next(null);
		return ptr2;
	}

	public static <T> LinearNode<T> fold(LinearNode<T> head) {
		LinearNode<T> mid = LinkedListUtil.middleNode(head);
		LinearNode<T> reversed = LinkedListUtil.rReverse(mid.next());
		LinkedListUtil.mergeAlternatively(head, reversed);
		return head;
	}

	public static <T extends Comparable<? super T>> LinearNode<T> mergeSorted(LinearNode<T> l1, LinearNode<T> l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		LinearNode<T> result = null;
		if (l1.getData().compareTo(l2.getData()) <= 0) {
			result = l1;
			result.next(mergeSorted(l1.next(), l2));
		} else {
			result = l2;
			result.next(mergeSorted(l1, l2.next()));
		}		
		return result;
	}

	public static <T extends Comparable<? super T>> MultiNode<T> flatten(MultiNode<T> root) {
		if (root.right() == null) {
			return root;
		}
		
		root.right(flatten(root.right()));	
				
		return mergeSortedMultiNode(root, root.right());
	}

	private static <T extends Comparable<? super T>> MultiNode<T> mergeSortedMultiNode(MultiNode<T> l1, MultiNode<T> l2) {
		if (l1 == null) {
			return l2;
		} else if(l2 == null){
			return l1;
		}
		MultiNode<T> result;
		if (l1.data().compareTo(l2.data()) < 0) {
			result = l1;
			result.down(mergeSortedMultiNode(l1.down(), l2));
		} else {
			result = l2;
			result.down(mergeSortedMultiNode(l1, l2.down()));
		}
		return result;
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
			temp.next(result);
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
			LinearNode<Integer> ll1Next = ll1 == null ? head1 : ll1.next();
			LinearNode<Integer> ll2Next = ll2 == null ? head2 : ll2.next();
			nextNode = doSum(ll1Next, ll2Next, 0, carry, head1, head2);
		}
		
		int val1 = ll1 != null ? ll1.getData() : 0;
		int val2 = ll2 != null ? ll2.getData() : 0;
		
		int sum = (val1 +val2 + carry[0]) %10;
		carry[0] = (val1+ val2+carry[0])/10;

		LinearNode<Integer> temp = new LinearNode<Integer>(sum);
		temp.next(nextNode);

		return temp;
	}

	private static<T> int countDiff(LinearNode<T> ll1, LinearNode<T> ll2) {
		int ls1 = length(ll1);
		int ls2 = length(ll2);
		return ls1-ls2;
	}

	public static LinearNode<Integer> seperateEvenAndOddNodes(LinearNode<Integer> head) {
		LinearNode<Integer> tail = head, prevNode=null, currNode = head, nextNode;
		int length = length(head), count = 0;
		boolean allEven = true, allOdd = true;
		//point to the last node, start dumping all nodes after this
		while (tail.next() != null) {
			if (tail.getData() % 2 == 0) {
				allOdd = false;
			} else {
				allEven = false;
			}
			tail = tail.next();
		}
		// Dont do anything if either all odd or all even
		if (allOdd || allEven) {
			return head;
		}
		// Make sure you don't go in infinite loop, and hence condition to make sure, you traverse limited nodes.
		while (currNode != null && count < length) {
			nextNode = currNode.next();
			//move currNode to the end of list, if it is odd.
			if (currNode.getData() % 2 == 1) {
				LinearNode<Integer> temp = currNode;
				if (prevNode != null) {
					prevNode.next(nextNode);
					currNode = prevNode;
				} else {
					head = nextNode;
					currNode = null;
				}
				tail.next(temp);
				tail = temp;
				temp.next(null);
			}
			prevNode = currNode;
			currNode = nextNode;
			count++;
		}
		//return the new head, in case the list begins with odd
		return head;
	}

	public static LinearNode<Integer> seperateEvenAndOddIndexNodes(LinearNode<Integer> head) {
		LinearNode<Integer> prevNode =null, currentNode = head, tail = head, nextNode;
		int length = length(head),index = 0;
		
		if (length < 3) {
			return head;
		}

		while (tail != null && tail.next() != null) {
			tail = tail.next();			
		}
		while (currentNode != null && index < length) {
			nextNode = currentNode.next();
			if (index % 2 == 1) {
				LinearNode<Integer> temp = currentNode;
				tail.next(temp);
				tail = temp;
				prevNode.next(nextNode);
				currentNode = prevNode;
				temp.next(null);
			}
			prevNode = currentNode;
			currentNode = nextNode;
			index++;
		}

		return head;
	}
	// refer http://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/
	public static <T> RandomLinearNode<T> clone(RandomLinearNode<T> head) {
		if (head == null) {
			return head;
		}
		RandomLinearNode<T> itr = head, temp;

		// insert copy nodes after each original nodes
		while (itr != null) {
			temp = new RandomLinearNode<T>(itr.getElement());
			temp.next(itr.next());
			itr.next(temp);
			itr = temp.next();
		}
		// copy the random pointer
		itr = head;
		while (itr != null && itr.next() != null) {
			if (itr.random() != null) {
				itr.next().random(itr.random().next());
			}
			itr = itr.next().next();
		}
		// break the list into two
		RandomLinearNode<T> newHead = head.next();
		itr = head;
		while (itr != null && itr.next() != null) {
			temp = itr.next();
			itr.next(temp.next());			
			itr = temp.next();
		}
		return newHead;
	}
}
