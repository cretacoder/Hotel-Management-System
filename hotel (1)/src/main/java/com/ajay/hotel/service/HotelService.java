package com.ajay.hotel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.hotel.dao.HotelDao;
import com.ajay.hotel.entity.Hotel;
import com.ajay.hotel.exception.InvalidHotelIdException;
import com.ajay.hotel.repository.HotelRepository;
import com.ajay.hotel.response.ResponseStructure;

@Service
public class HotelService {

	@Autowired 
	HotelDao h_dao;
	@Autowired
	HotelRepository h_repo;
		public ResponseStructure<Hotel> register(Hotel hotel) {
			Hotel hotel1 = h_dao.register(hotel);
			
			ResponseStructure<Hotel> str = new ResponseStructure<Hotel>();
			str.setData(hotel1);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("register Succesfully");
			str.setStatusCode(201);
			return str;
		}
		public Optional<Hotel> getHotelById(int hotel_id) {
		Optional<Hotel> hotel = h_dao.getHotelById(hotel_id);
		if(hotel.isPresent()) {
			return hotel;
		}else {
			throw new InvalidHotelIdException();
		}

	}
	
	public List<Hotel> getAllHotel() {
		List<Hotel> hotel = h_dao.getAllHotel();
		if (hotel!=null) {
		return hotel;
		}
		else {
		throw new IllegalArgumentException("Hotel is empty pls add the hotel");
		}
	}
	
	public ResponseStructure<Hotel> updateById(int hotel_Id,Hotel hotel) {
		Optional<Hotel> message = h_dao.updateById(hotel_Id);
		if(message.isPresent()) {
			Hotel hotel1 = message.get();
			hotel1.setHotel_id(hotel_Id);
			hotel1.setHotel_address(hotel.getHotel_address());
			hotel1.setHotel_gst(hotel.getHotel_gst());
			hotel1.setHotel_manager(hotel.getHotel_manager());
			hotel1.setHotel_name(hotel.getHotel_name());
			hotel1.setHotel_owner(hotel.getHotel_owner());
			hotel1.setHotel_rating(hotel.getHotel_rating());
			Hotel hotel2 = h_dao.register(hotel1);
			ResponseStructure<Hotel> str = new ResponseStructure<Hotel>();
			str.setData(hotel2);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("Hotel "+ hotel.getHotel_name()+ "update Succesfully");
			str.setStatusCode(200);
			return str;

		}
		else {
			throw new IllegalArgumentException("no object check empId");
		}
	}


	public ResponseStructure<Hotel> deleteById(int hotel_Id) {
		Optional<Hotel> del=h_dao.delete(hotel_Id);
		
		if(del.isPresent()) {
			Hotel hotel = del.get();
			h_repo.delete(hotel);
			ResponseStructure<Hotel> str =new ResponseStructure<Hotel>();
			str.setData(hotel);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("Name  "+hotel.getHotel_name()+"  Deleted Succesfully");
			str.setStatusCode(200);
			return str;
		}
		else {
			throw new IllegalArgumentException("Check Id");
		}
		
	}

}
