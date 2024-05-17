package com.lcwd.rating.ratings.entities.service;

import java.util.List;
import com.lcwd.rating.ratings.entities.Rating;

public interface RatingService {
	public Rating create(Rating rating);
	public List<Rating> getAll();
	public Rating getById(String id);
	public List<Rating> getRatingByUserId(String userId);
}