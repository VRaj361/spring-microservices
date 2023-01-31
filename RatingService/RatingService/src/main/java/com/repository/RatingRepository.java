package com.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.entity.RatingEntity;

public interface RatingRepository extends MongoRepository<RatingEntity, String>{
	
	List<RatingEntity> findByUserId(String userId);
	List<RatingEntity> findByHotelId(String hotelId);
}
