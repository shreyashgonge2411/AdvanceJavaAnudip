package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;


@Controller
public class HotelController {
	private HotelService  hotelService;
	
	public HotelController(HotelService  hotelService) {
		super();
		this.hotelService =hotelService;
	}
	
	@GetMapping("/hotels")
	public String hotelList(Model model) {
		model.addAttribute("hotel",hotelService.getAllHotels());
		return "hotels";
	}
	
	//Redirect a Register page 
	@GetMapping("/hotels/register")
	public String createHotelForm(Model model) {
		Hotel hotel = new Hotel();
		model.addAttribute("hotels", hotel);
		return "register";
	}
	
	@PostMapping("/hotels")
	public String saveHotels(@ModelAttribute("hotels") Hotel hotel ) {
		hotelService.saveHotel(hotel);
		return "redirect:/hotels";
	}
	
	@GetMapping("/hotels/edit/{id}")
	public String editHotelForm(@PathVariable Long id,Model model) {
		model.addAttribute("hotel",hotelService.getHotelById(id));
		return "edit_hotels";
	}
	
	@PostMapping("/update/{id}")
	public String updateHotel(@PathVariable Long id, @ModelAttribute("hotel") Hotel hotel, Model model) {
		Hotel existing = hotelService.getHotelById(id);
		existing.setId(hotel.getId());
		existing.setHotelname(hotel.getHotelname());
		existing.setAddress(hotel.getAddress());
		existing.setEmail(hotel.getEmail());
		existing.setNumber(hotel.getNumber());
		
		hotelService.updateHotelById(existing);
		return "redirect:/hotels";
	}
	
	@GetMapping("/hotels/{id}")
	public String deleteHotel(@PathVariable Long id) {
		hotelService.deleteHotelById(id);
		return "redirect:/hotels";
	}
}
