package com.ajay.hotel.exception;

public class InvalidHotelIdException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "Invalid Id please try Again!!";
	}
}
