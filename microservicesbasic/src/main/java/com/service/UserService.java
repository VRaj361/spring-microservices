package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.entity.HotelEntity;
import com.entity.RatingEntity;
import com.entity.UserEntity;
import com.exception.ResourceNotFoundException;
import com.externalServices.HotelService;
import com.repository.UserRepository;


@Controller
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	private HotelService hotelService;
	//for calling hotelService using FeignClient
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	//for save the user
	public UserEntity saveUser(UserEntity user) {
		userRepo.save(user);
		return user;
	}
	
	
	//for get all user
	public List<UserEntity> getAllUser(){
		return userRepo.findAll();
	}
	
	
	//for get particular user using id
	public UserEntity getUser(String userId) {
		UserEntity user =  userRepo.findById(userId).orElseThrow(() ->  new ResourceNotFoundException("User given id not exists.."));
		RatingEntity[] rat = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUserid(), RatingEntity[].class );
		//localhost
//		logger.info("{} ",rat);
		List<RatingEntity> ratin =  Arrays.stream(rat).toList();
		List<RatingEntity> ratings = ratin.stream().map(rating -> {
			//HotelEntity hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), HotelEntity.class);
			HotelEntity hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratings);
		return user;
	}
	
}
