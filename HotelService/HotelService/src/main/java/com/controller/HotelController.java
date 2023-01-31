package com.controller;


import com.entity.HotelEntity;
import com.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelEntity> getHotel(@PathVariable("hotelId") String hotelId){
        HotelEntity hotel =  hotelService.getHotel(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

    @GetMapping
    public ResponseEntity<List<HotelEntity>> getAllHotels(){
        List<HotelEntity> hotels = hotelService.getHotels();
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }

    @PostMapping
    public ResponseEntity<HotelEntity> addHotel(@RequestBody HotelEntity hotel){
        HotelEntity hotel1 = hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
}
