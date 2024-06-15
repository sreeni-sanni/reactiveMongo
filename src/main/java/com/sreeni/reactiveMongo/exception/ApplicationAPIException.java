package com.sreeni.reactiveMongo.exception;

public class ApplicationAPIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6613325607134077600L;

	public ApplicationAPIException(String message) {
		super(String.format(message));
	}

}
