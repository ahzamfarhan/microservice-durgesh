package com.lcwd.userservice.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.userservice.exceptions.UserNotFoundException;
import com.lcwd.userservice.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException exception) {
		
		ApiResponse apiResponse = ApiResponse.builder()
			.message(exception.getMessage())
			.success(true)
			.status(HttpStatus.NOT_FOUND)
			.build();
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
		
	}
}
