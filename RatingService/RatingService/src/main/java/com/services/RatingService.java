package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.entity.RatingEntity;
import com.repository.RatingRepository;

@Controller
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepo;
	
	//add rating
	public RatingEntity addRating(RatingEntity rating) {
		return ratingRepo.save(rating);
	}
	
	//get all rating
	public List<RatingEntity> getRatings(){
		return ratingRepo.findAll();
	}
	
	//get rating by userId
	public List<RatingEntity> getRatingByUserid(String userId) {
		return ratingRepo.findByUserId(userId);
	}
	
	//get rating by hotelId
	public List<RatingEntity> getRatingByHotelid(String hotelId){
		return ratingRepo.findByHotelId(hotelId);
	}
	
	
}
