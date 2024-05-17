package com.lcwd.rating.ratings.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.rating.ratings.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
	public List<Rating> findByUserId(String userId);
}
