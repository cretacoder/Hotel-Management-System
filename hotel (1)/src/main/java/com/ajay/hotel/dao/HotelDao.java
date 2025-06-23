package com.ajay.hotel.dao;

 import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajay.hotel.entity.Hotel;
import com.ajay.hotel.repository.HotelRepository;

@Component
public class HotelDao {
@Autowired
HotelRepository h_repo;
	public Hotel register(Hotel hotel) {
		return h_repo.save(hotel);
		
	}
	public Optional<Hotel> getHotelById(int hotel_Id) {
		return h_repo.findById(hotel_Id);
	}
	public List<Hotel> getAllHotel() {
		return h_repo.findAll();
	}
	
	public Optional<Hotel> updateById(int hotel_Id) {
		return h_repo.findById(hotel_Id);
	}

	public Optional<Hotel> delete(int hotel_Id) {
		return h_repo.findById(hotel_Id);

    }
}
