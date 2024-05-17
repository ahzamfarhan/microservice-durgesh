package com.lcwd.hotel.entities.services.impls;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.entities.repositories.HotelRepository;
import com.lcwd.hotel.entities.services.HotelService;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		
		hotel.setId(UUID.randomUUID().toString());
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getById(String id) {
		return hotelRepository.findById(id)
					.orElseThrow(()-> 
						new ResourceNotFoundException("Hotel by specified "
																+ "Id does exist"));
	}

}
