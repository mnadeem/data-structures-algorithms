package com.nadeem.app.dsa.adt.impl;

import com.nadeem.app.dsa.adt.Queue;
import com.nadeem.app.dsa.exception.CollectionEmptyException;
import com.nadeem.app.dsa.exception.CollectionFullException;

public class ArrayHeap<T extends Comparable<? super T>> implements Queue<T> {

	private int lastIndex;
	private int maxIndex;
	private T[] elements;

	@SuppressWarnings("unchecked")
	public ArrayHeap(int maxSize) {
		this.maxIndex = maxSize - 1;
		this.lastIndex = -1;
		this.elements = (T[]) new Comparable[maxSize];
	}

	@Override
	public void enqueue(T element) {
		if (this.lastIndex == this.maxIndex) {
			throw new CollectionFullException();
		} else {
			this.lastIndex++;
			heapifyAdd(element);
		}		
	}

	private void heapifyAdd(T element) {
		int next = this.lastIndex;
		while(next > 0 && element.compareTo(parentOf(next)) > 0) {
			int parentIndex = parentIndex(next);
			this.elements[next] = this.elements[parentIndex];
			next = parentIndex;
		}
		this.elements[next] = element;
	}

	private T parentOf(int nodeIndex) {
		return this.elements[parentIndex(nodeIndex)];
	}

	private int parentIndex(int nodeIndex) {
		return (nodeIndex - 1)/2;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new CollectionEmptyException();
		}
		T maxElement = this.elements[0];
		int elementToRemove = lastIndex--;
		this.elements[0] = this.elements[elementToRemove];
		this.elements[elementToRemove] = null;
		if (this.size() >= 1) {			
			heapifyRemove(0);
		}

		return maxElement;
	}

	private void heapifyRemove(int index) {
		T top = this.elements[index];//save root
		int largerChild;
		while (!isLeaf(index)) { //while Node has at least one child
			largerChild = largerChild(index);
			
			if (top.compareTo(this.elements[largerChild]) >= 0) {
				break ;
			}
			this.elements[index] = this.elements[largerChild];
			index = largerChild;
		}
		this.elements[index] = top;
	}

	private int largerChild(int index) {
		int largerChild;
		int leftChild = 2*index + 1;
		int rightChild = leftChild + 1;
		if(rightChild <= this.lastIndex
				&& this.elements[rightChild].compareTo(this.elements[leftChild]) > 0) {
			largerChild = rightChild;
		} else {
			largerChild = leftChild;
		}
		return largerChild;
	}

	@Override
	public int size() {
		return lastIndex + 1;
	}

	@Override
	public boolean isEmpty() {
		return lastIndex == -1;
	}
	
	private boolean isLeaf(int index)
	{ 
		return (index >= this.size()/2) && (index < this.size()); 
	}

}
