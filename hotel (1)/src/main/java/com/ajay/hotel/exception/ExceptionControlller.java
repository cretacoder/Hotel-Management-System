package com.ajay.hotel.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionControlller {

	@ExceptionHandler(value = InvalidHotelIdException.class)
	public ResponseEntity<?>invalidEmployeeId(InvalidHotelIdException exception){
		ApiError apiError = new ApiError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setMessage(exception.getMessage());
		apiError.setExceptionClass(exception.getClass());
		
		return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InvalidMgrIdException.class)
	public ResponseEntity<?>invalidMgrId(InvalidMgrIdException exception){
		ApiError apiError = new ApiError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setMessage(exception.getMessage());
		apiError.setExceptionClass(exception.getClass());
		return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = InvalidRoomIdException.class)
	public ResponseEntity<?>invalidRoomId(InvalidRoomIdException exception){
		ApiError apiError = new ApiError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setMessage(exception.getMessage());
		apiError.setExceptionClass(exception.getClass());
		return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = InvalidCmrIdException.class)
	public ResponseEntity<?>invalidCmrId(InvalidCmrIdException exception){
		ApiError apiError = new ApiError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setMessage(exception.getMessage());
		apiError.setExceptionClass(exception.getClass());
		return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = InvalidBookingIdException.class)
	public ResponseEntity<?>invalidBookingId(InvalidBookingIdException exception){
		ApiError apiError = new ApiError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setMessage(exception.getMessage());
		apiError.setExceptionClass(exception.getClass());
		return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
	}
}
