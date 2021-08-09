package com.wyssmann.sampleapps.exceptions;

/**
 * Exception thrown if an invalid command is provided
 */
public class InvalidCommandException extends Exception {


	private static final long serialVersionUID = -8443038779504372489L;
	
	public InvalidCommandException(String message) { super(message); }
	public InvalidCommandException(String message, Throwable cause) { super(message, cause); }
 	public InvalidCommandException(Throwable cause) { super(cause); }
}
