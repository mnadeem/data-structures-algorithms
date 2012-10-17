package com.nadeem.app.dsa.exception;

public class CollectionFullException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CollectionFullException() {
		super("Collection is Full");
	}

}
