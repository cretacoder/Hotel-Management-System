package com.ajay.hotel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ajay.hotel.dao.RoomDao;
import com.ajay.hotel.entity.Hotel;

import com.ajay.hotel.entity.Room;
import com.ajay.hotel.exception.InvalidRoomIdException;
import com.ajay.hotel.repository.HotelRepository;
import com.ajay.hotel.repository.RoomRepository;
import com.ajay.hotel.response.ResponseStructure;

@Service
public class RoomService {
	@Autowired
	RoomRepository roomRepo;
	@Autowired
	RoomDao roomDao;
	@Autowired
	HotelRepository h_repo;
	
	
	
public ResponseStructure<Room> register(Room room, int hotel_Id) {
			Optional<Hotel> htl=h_repo.findById(hotel_Id);
			Hotel hotel = htl.get();
			room.setHotel(hotel);
			Room rm=roomDao.register(room);
			ResponseStructure<Room> str = new ResponseStructure<Room>();
			str.setData(rm);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("Room register Succesfully");
			str.setStatusCode(201);
			return str;
}

public Optional<Room> getRoomById(int room_id) {
	Optional<Room> rm = roomDao.getRoomById(room_id);
	if(rm.isPresent()) {
		return rm;
	}else {
		throw new InvalidRoomIdException();
	}

}

public List<Room> getAllRoom() {
	List<Room> room = roomDao.getAllRoom();
	if (room!=null) {
	return room;
	}
	else {
	throw new IllegalArgumentException("No room is added pls add the Room");
	}
}

public ResponseStructure<Room> updateById(int room_id,Room room) {
	Optional<Room> room1 = roomDao.updateById(room_id);
	if(room1.isPresent()) {
		Room rm = room1.get();

		rm.setRoom_no(room.getRoom_no());
		rm.setRoom_price(room.getRoom_price());
		rm.setRoom_type(room.getRoom_type());
		rm.setAvailablity(room.getAvailablity());
		rm.setMax_people(room.getMax_people());
		rm.setNo_beds(room.getNo_beds());
		Room rm1 = roomDao.register(rm);
		
		ResponseStructure<Room> str = new ResponseStructure<Room>();
		str.setData(rm1);
		str.setTimeStamp(LocalDateTime.now());
		str.setMessage("Room update Succesfully");
		str.setStatusCode(200);
		return str;

	}
	else {
		throw new IllegalArgumentException("no object check room_id");
	}

}

public ResponseStructure<Room> deleteById(int room_id) {
	Optional<Room> del=roomDao.delete(room_id);
	if(del.isPresent()) {
		Room rm = del.get();
		roomRepo.delete(rm);
		ResponseStructure<Room> str =new ResponseStructure<Room>();
		str.setData(rm);
		str.setTimeStamp(LocalDateTime.now());
		str.setMessage("Room No  "+rm.getRoom_no()+"  Deleted Succesfully");
		str.setStatusCode(200);
		return str;
	}
	else {
		throw new IllegalArgumentException("Check Id");
	}
	
}
}
