package com.ajay.hotel.exception;

public class InvalidRoomIdException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid Room Id pls Check the Id";
	}
}
