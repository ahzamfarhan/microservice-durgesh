package com.lcwd.userservice.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@RateLimiter(name="myRateLimiter", fallbackMethod = "dummyStaffFallback")
	@GetMapping
	public ResponseEntity<List<String>> getStaff() {
		return ResponseEntity.ok(List.of("Farhan", "Anwar", "Ahzam", "Guddu", "Ibrahim"));
	}
	
	
	public ResponseEntity<List<String>> dummyStaffFallback() {
		return ResponseEntity.ok(List.of("DUMMY-1", "DUMMY-2", "DUMMY-3", "DUMMY-4"));
	}
}