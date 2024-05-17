package com.lcwd.rating.ratings.entities.service.impls;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lcwd.rating.ratings.entities.Rating;
import com.lcwd.rating.ratings.entities.service.RatingService;
import com.lcwd.rating.ratings.exceptions.ResourceNotFoundException;
import com.lcwd.rating.ratings.repositories.RatingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RatinginServiceImpl implements RatingService {

	private RatingRepository ratingRepository;
	
	@Override
	public Rating create(Rating rating) {
		rating.setRatingId(UUID.randomUUID().toString());
		return ratingRepository.save(rating);
	}
	
	@Override
	public List<Rating> getAll() {
		return ratingRepository.findAll();
	}
	
	@Override
	public Rating getById(String id) {
		
		return ratingRepository.findById(id).orElseThrow(()-> 
					new ResourceNotFoundException("Rating By Id not found",
							HttpStatus.NOT_FOUND, "100", false));
	}
	
	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}
}