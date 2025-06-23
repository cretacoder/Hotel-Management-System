package com.ajay.hotel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajay.hotel.entity.Room;
import com.ajay.hotel.repository.RoomRepository;
@Component
public class RoomDao {
	@Autowired
	RoomRepository roomRepo;


	public Room register(Room room) {
		return roomRepo.save(room);
	}

	public Optional<Room> getRoomById(int room_id) {
		return roomRepo.findById(room_id);	
	}
	public List<Room> getAllRoom() {
		return roomRepo.findAll();
	}

	public Optional<Room> updateById(int room_id) {
		return roomRepo.findById(room_id);
	}

	public Optional<Room> delete(int room_id) {
		return roomRepo.findById(room_id);


	}
}
