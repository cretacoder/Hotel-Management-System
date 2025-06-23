package com.ajay.hotel.exception;

public class InvalidCmrIdException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Check the customer Id pls";
	}
}
