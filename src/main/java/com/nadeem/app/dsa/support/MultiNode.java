package com.nadeem.app.dsa.support;

public class MultiNode<T> {
	private T data;
	private MultiNode<T> right;
	private MultiNode<T> down;
	
	public MultiNode(T data) {
		this.data = data;
	}
	public MultiNode(T data, MultiNode<T> down) {
		this.data = data;
		this.down = down;
	}
	
	public MultiNode(T data, MultiNode<T> right, MultiNode<T> down) {
		this.data = data;
		this.right = right;
		this.down = down;
	}

	public T data() {
		return data;
	}

	public void data(T data) {
		this.data = data;
	}

	public MultiNode<T> right() {
		return right;
	}

	public void right(MultiNode<T> right) {
		this.right = right;
	}

	public MultiNode<T> down() {
		return down;
	}

	public void down(MultiNode<T> down) {
		this.down = down;
	}
	
	
}
