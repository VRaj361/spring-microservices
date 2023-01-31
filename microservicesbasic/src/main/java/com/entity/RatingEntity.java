package com.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingEntity {
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	private HotelEntity hotel;
	public static RatingEntityBuilder builder() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
