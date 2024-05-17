package com.lcwd.userservice.exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super("Resource Not Found Exception");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
