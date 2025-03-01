package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService service;
	
	@GetMapping
	public List<Hotel> getAll(){
		return service.getAllHotel();
	}
	
	@PostMapping
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return service.insertHotel(hotel);
	}
	
	@GetMapping("/{id}")
	public Hotel getHotelById(@PathVariable Long id) {
		return service.getHotelById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateById(@PathVariable Long id, @RequestBody Hotel hotel){
		Hotel existing = service.getHotelById(id);
		if(existing != null) {
			existing.setName(hotel.getName());
			existing.setAddress(hotel.getAddress());
			existing.setEmail(hotel.getEmail());
			existing.setPassword(hotel.getPassword());
			
			Hotel save = service.updateHotelById(existing);
			return ResponseEntity.ok(save);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotelById(@PathVariable Long id){
		boolean isExist = service.deleteHotelById(id);
		if(isExist) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
