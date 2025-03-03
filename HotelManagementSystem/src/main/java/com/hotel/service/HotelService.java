package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {
	
	//List of all hotels
	List<Hotel> getAllHotels();
		
	//add hotels
	Hotel saveHotel(Hotel hotel);
		
	//get hotel details by id
	Hotel getHotelById(Long id);
		
	//update hotel details by id
	Hotel updateHotelById(Hotel hotel);
		
	//delete hotel by id
	void deleteHotelById(Long id);
}
