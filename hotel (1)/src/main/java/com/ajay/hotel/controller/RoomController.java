package com.ajay.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.hotel.entity.Room;
import com.ajay.hotel.response.ResponseStructure;
import com.ajay.hotel.service.RoomService;

@RestController
@RequestMapping("/Room")
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@PostMapping("/register")
	ResponseEntity<?>register(@RequestBody Room room,int hotel_Id){
		ResponseStructure<Room> rm = roomService.register(room,hotel_Id);
		return new ResponseEntity<>(rm,HttpStatus.OK);
	}
	
		@GetMapping("/getById")
		public ResponseEntity<?> getRoomById (@RequestParam int room_id){
			Optional<Room> rm = roomService.getRoomById(room_id);
			return new ResponseEntity<>(rm,HttpStatus.FOUND);
		}
		
		@GetMapping("/getAllRoom")
		public ResponseEntity<?>getAllRoom(){
				List<Room> rm = roomService.getAllRoom();
			return new ResponseEntity<>(rm,HttpStatus.FOUND);
		}
		@PutMapping("/updateById")
		public ResponseEntity<?> updateById (@RequestParam int room_id,@RequestBody Room room){
			ResponseStructure<Room> rm = roomService.updateById(room_id, room);
			return new ResponseEntity<>(rm,HttpStatus.OK);
		}
		@DeleteMapping("/delete")
		public ResponseEntity<?> deleteById(@RequestParam int room_id){
			ResponseStructure<Room> rm = roomService.deleteById(room_id);
			return new ResponseEntity<>(rm,HttpStatus.OK);
		}
	
}
