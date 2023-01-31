package com.services;

import com.entity.HotelEntity;
import com.exception.ResourceNotFoundException;
import com.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HotelService
{

    @Autowired
    private HotelRepository hotelRepository;

    //get specific hotel using id
    public HotelEntity getHotel(String hotelId){
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Resource is not found..."));
    }

    //get all hotels
    public List<HotelEntity> getHotels(){
        return hotelRepository.findAll();
    }

    //add hotel
    public HotelEntity addHotel(HotelEntity hotel){
        return hotelRepository.save(hotel);
    }


}
