package com.ajay.hotel.exception;

public class InvalidMgrIdException extends RuntimeException{

	@Override
	public String getMessage() {
		return "Invalid Id please try Again!!";
	}
}
