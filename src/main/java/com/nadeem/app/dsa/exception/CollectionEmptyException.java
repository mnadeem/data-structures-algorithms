package com.nadeem.app.dsa.exception;

public class CollectionEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CollectionEmptyException() {
		super("Collection Can't be empty");
	}
}
