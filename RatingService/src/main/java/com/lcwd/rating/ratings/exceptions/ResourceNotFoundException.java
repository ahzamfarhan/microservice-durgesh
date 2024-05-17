package com.lcwd.rating.ratings.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResourceNotFoundException extends RuntimeException {

	private HttpStatus httpStatus;
	private String errorCode;
	private boolean status;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String message, HttpStatus httpStatus, 
				String errorCode, boolean status) {
		super(message);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.status = status;
	}
}
