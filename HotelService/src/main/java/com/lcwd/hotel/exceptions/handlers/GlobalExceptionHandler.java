package com.lcwd.hotel.exceptions.handlers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.hotel.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
		
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		
		map.put("message", ex.getMessage());
		map.put("httpStatus", ex.getHttpStatus());
		map.put("success", true);
		map.put("errorCode", ex.getErrorCode());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		
	}
}
