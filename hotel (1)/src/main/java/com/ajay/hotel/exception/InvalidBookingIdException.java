package com.ajay.hotel.exception;

public class InvalidBookingIdException extends RuntimeException {
@Override
public String getMessage() {
	return "Check the booking id";
}
}
