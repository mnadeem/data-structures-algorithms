package com.nadeem.app.dsa.support;

public class BinaryTreeNode<T> {
	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	
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
	
}
