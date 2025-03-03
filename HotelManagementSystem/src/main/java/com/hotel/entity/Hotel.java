package com.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HotelDB")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String hotelname;
	private String address;
	private String email;
	private String number;

	public Hotel(Long id,String hotelname,String address,String email, String number) {
		super();
		this.id = id;
		this.hotelname = hotelname;
		this.address = address;
		this.email = email;
		this.number = number;
	}

	public Hotel() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", hotelname=" + hotelname + ", address=" + address + ", email=" + email
				+ ", number=" + number + "]";
	}
	
	
	
	
}
