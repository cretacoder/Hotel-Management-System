package com.ajay.hotel.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiError {
	
	private LocalDateTime timeStamp;
	private String message;
	private Class exceptionClass;
}
