package com.ajay.hotel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajay.hotel.entity.Booking;
import com.ajay.hotel.repository.BookingRepository;

@Component
public class BookingDao {
	@Autowired
	BookingRepository bkRepo;


	public Booking register(Booking bk) {
		return bkRepo.save(bk);
	}

	public Optional<Booking> getBookingById(int b_id) {
		return bkRepo.findById(b_id);	
	}
	public List<Booking> getAllBooking() {
		return bkRepo.findAll();
	}

	public Optional<Booking> updateById(int b_id) {
		return bkRepo.findById(b_id);
	}

	public Optional<Booking> delete(int b_id) {
		return bkRepo.findById(b_id);


	}
}
