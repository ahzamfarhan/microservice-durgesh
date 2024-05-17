package com.lcwd.userservice.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.userservice.models.Hotel;


@FeignClient(name="HOTELSERVICE")
public interface HotelClientService {
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<Hotel> getById(@PathVariable(value = "hotelId") String hotelId); 
}