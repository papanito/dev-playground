package com.wyssmann.sampleapps.exceptions;

/**
 * Exception thrown if an invalid arguments are provided
 */
public class InvalidArgumentsException extends Exception {


	private static final long serialVersionUID = -8443038779504372489L;
	
	public InvalidArgumentsException(String message) { super(message); }
	public InvalidArgumentsException(String message, Throwable cause) { super(message, cause); }
 	public InvalidArgumentsException(Throwable cause) { super(cause); }
}
