package com.nadeem.app.dsa.support;

public class BinaryTreeNode<T> {
	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private BinaryTreeNode<T> next;
	
	public BinaryTreeNode(T newData) {
		this.data = newData;
	}
	
	public BinaryTreeNode(T newData, BinaryTreeNode<T> l, BinaryTreeNode<T> r) {
		this(newData);
		this.left = l;
		this.right = r;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	public BinaryTreeNode<T> getNext() {
		return next;
	}

	public void setNext(BinaryTreeNode<T> next) {
		this.next = next;
	}

	public boolean isLeafNode() {
		return this.getLeft() == null && this.getRight() == null;
	}

	public boolean hasBothChildren() {
		return this.getLeft() != null && this.getRight() != null;
	}

	public boolean hasLeftChild() {
		return this.getLeft() != null;
	}
	
	public boolean hasRightChild() {
		return this.getRight() != null;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.getData());
	}

	public boolean isParentOf(BinaryTreeNode<Integer> lastNode) {
		if( this.getLeft() == lastNode || this.getRight() == lastNode)
			return true;
		return false;
	}
}
