package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.RatingEntity;
import com.externalServices.RatingService;

@SpringBootTest
class MicroservicesbasicApplicationTests {

	
	@Autowired
	private RatingService ratingService;
	@Test
	void contextLoads() {
	}

	@Test
	void createRating() {
		RatingEntity rat = RatingEntity.builder().rating(10).userId("").hotelId("").feedback("This is sample feedback by UserService").build();
		RatingEntity rating = ratingService.createRating(rat);
		System.out.println("New Rating Service is created");
	}
}
