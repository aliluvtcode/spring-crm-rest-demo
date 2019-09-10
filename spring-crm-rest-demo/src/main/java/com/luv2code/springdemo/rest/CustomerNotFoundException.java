package com.luv2code.springdemo.rest;

import javax.management.RuntimeErrorException;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CustomerNotFoundException(String message) {
		super(message);
		
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
		
	}

	
	
}
