package com.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	private HotelRepository hotelRepository;
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(Long id) {
		return hotelRepository.findById(id).get();
	}

	@Override
	public Hotel updateHotelById(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public void deleteHotelById(Long id) {
		// TODO Auto-generated method stub
		hotelRepository.deleteById(id);
	}
	
	
}
