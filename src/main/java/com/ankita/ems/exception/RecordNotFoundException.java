package com.ankita.ems.exception;

/**
 * Custom exception for the case of absence of record or data
 *
 */
public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message) {
		super(message);
	}

}