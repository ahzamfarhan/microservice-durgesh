package com.lcwd.userservice.feign_clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lcwd.userservice.models.Rating;

//http://RATINGSERVICE/ratings/users/{userId}

@FeignClient(name = "RATINGSERVICE")
public interface RatingClientService {
	@GetMapping("/ratings/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId);
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating);
}
