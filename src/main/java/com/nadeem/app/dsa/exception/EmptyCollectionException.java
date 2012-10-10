package com.nadeem.app.dsa.exception;

public class EmptyCollectionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmptyCollectionException() {
		super("Collection Can't be empty");
	}

}
