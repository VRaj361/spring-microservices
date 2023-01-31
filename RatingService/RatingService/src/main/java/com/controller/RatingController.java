package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RatingEntity;
import com.services.RatingService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rating")
public class RatingController {

	@Autowired
    private RatingService ratingService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingEntity>> getRatingByUserid(@PathVariable("userId") String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserid(userId));
    }
    
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RatingEntity>> getRatingByHotelid(@PathVariable("hotelId") String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body( ratingService.getRatingByHotelid(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<RatingEntity>> getAllRatings(){
        List<RatingEntity> ratings = ratingService.getRatings();
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @PostMapping
    public ResponseEntity<RatingEntity> addRating(@RequestBody RatingEntity rating){
        RatingEntity rat = ratingService.addRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rat);
    }
}
