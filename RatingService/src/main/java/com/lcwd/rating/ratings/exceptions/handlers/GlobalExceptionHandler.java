package com.lcwd.rating.ratings.exceptions.handlers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.rating.ratings.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		
		map.put("message", ex.getMessage());
		map.put("http-status",ex.getHttpStatus());
		map.put("error-code", ex.getErrorCode());
		map.put("status", ex.isStatus());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
