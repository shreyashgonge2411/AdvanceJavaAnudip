package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepo;

@Service
public class HotelService {
	@Autowired
	private HotelRepo hotelRepo;
	
	public List<Hotel> getAllHotel(){
		return hotelRepo.findAll();
	}
	
	public Hotel insertHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}
	
	public Hotel updateHotelById(Hotel hotel) {
		return hotelRepo.save(hotel);
	}
	
	public Hotel getHotelById(Long id) {
		return hotelRepo.findById(id).orElse(null);
	}
	
	public boolean deleteHotelById(Long id) {
		if(hotelRepo.existsById(id)) {
			hotelRepo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
}
