package com.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.service.annotation.PutExchange;

import com.entity.RatingEntity;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	
	@GetMapping("/rating")
	public RatingEntity createRating(RatingEntity rating);
	
	@PutMapping("/rating/{ratingId}")
	public RatingEntity updateRating(@PathVariable("ratingId") String ratingId,RatingEntity rating);
	
	@DeleteMapping("/rating/{ratingId}")
	public void removeRating(@PathVariable("ratingId") String ratingId);
}
