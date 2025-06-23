package com.ajay.hotel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.hotel.dao.BookingDao;
import com.ajay.hotel.entity.Booking;
import com.ajay.hotel.entity.Customer;
import com.ajay.hotel.entity.Room;
import com.ajay.hotel.exception.InvalidBookingIdException;
import com.ajay.hotel.repository.BookingRepository;
import com.ajay.hotel.repository.CustomerRepository;
import com.ajay.hotel.repository.RoomRepository;
import com.ajay.hotel.response.ResponseStructure;

@Service
public class BookingService {
	@Autowired
	BookingRepository bkRepo;
	@Autowired
	BookingDao bkDao;
	@Autowired
	CustomerRepository c_repo;
	@Autowired
	RoomRepository r_repo;



	public ResponseStructure<Booking> register(Booking booking, int room_id,int customer_id) {
		Optional<Room> room=r_repo.findById(room_id);
		Optional<Customer> cmr =c_repo.findById(customer_id);

		Room room1 = room.get();
		booking.setRoom(room1);
		Customer cmr1 = cmr.get();
		booking.setCustomer(cmr1);

		Booking	bk=bkDao.register(booking);

		ResponseStructure<Booking> str = new ResponseStructure<Booking>();
		str.setData(bk);
		str.setTimeStamp(LocalDateTime.now());
		str.setMessage("Booking register Succesfully");
		str.setStatusCode(201);
		return str;
	}

	public Optional<Booking> getBookingById(int b_id) {
		Optional<Booking> mgr = bkDao.getBookingById(b_id);
		if(mgr.isPresent()) {
			return mgr;
		}else {
			throw new InvalidBookingIdException();
		}

	}

	public List<Booking> getAllBooking() {
		List<Booking> bk = bkDao.getAllBooking();
		if (bk!=null) {
			return bk;
		}
		else {
			throw new IllegalArgumentException("Booking is empty");
		}
	}

	public ResponseStructure<Booking> updateById(int b_id,Booking booking) {
		Optional<Booking> bk = bkDao.updateById(b_id);
		if(bk.isPresent()) {
			Booking bk1 = bk.get();

			bk1.setCheck_in_date(booking.getCheck_in_date());
			bk1.setCheck_out_date(booking.getCheck_out_date());
			bk1.setNo_people(booking.getNo_people());
			bk1.setRating(booking.getRating());
			
			Booking	bk2=bkDao.register(bk1);

			ResponseStructure<Booking> str = new ResponseStructure<Booking>();
			str.setData(bk2);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("Booking update Succesfully");
			str.setStatusCode(200);
			return str;

		}
		else {
			throw new IllegalArgumentException("no object check Booking Id");
		}

	}

	public ResponseStructure<Booking> deleteById(int b_Id) {
		Optional<Booking> del=bkDao.delete(b_Id);
		if(del.isPresent()) {
			Booking bk = del.get();
			bkRepo.delete(bk);
			ResponseStructure<Booking> str =new ResponseStructure<Booking>();
			str.setData(bk);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("Booking  id  "+bk.getB_id()+"  Deleted Succesfully");
			str.setStatusCode(200);
			return str;
		}
		else {
			throw new IllegalArgumentException("Check Id");
		}

	}

}
