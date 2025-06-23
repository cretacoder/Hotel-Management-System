package com.ajay.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.hotel.entity.Hotel;
import com.ajay.hotel.response.ResponseStructure;
import com.ajay.hotel.service.HotelService;


@CrossOrigin("*")
@RestController
@RequestMapping("/Hotel")
public class HoterController {
 @Autowired
 HotelService h_service;
 
 		@PostMapping("/register")
 		public ResponseEntity<?> register (@RequestBody Hotel hotel){
 			ResponseStructure<Hotel> regHotel = h_service.register(hotel);
 			return new ResponseEntity<>(regHotel,HttpStatus.CREATED);
 		}
 		@GetMapping("/getById")
 		public ResponseEntity<?> getHotelById (@RequestParam int h_id){
 			Optional<Hotel> htl = h_service.getHotelById(h_id);
 			return new ResponseEntity<>(htl,HttpStatus.OK);
 		}
 		@GetMapping("/getAllHotel")
 		public ResponseEntity<?>getAllHotel(){
 				List<Hotel> htl = h_service.getAllHotel();
 			return new ResponseEntity<>(htl,HttpStatus.OK);
 		}
 		@PutMapping("/updateById")
 		public ResponseEntity<?> updateById (@RequestParam int h_id,@RequestBody Hotel hotel){
 			ResponseStructure<Hotel> htl = h_service.updateById(h_id, hotel);
 			return new ResponseEntity<>(htl,HttpStatus.OK);
 		}
 		@DeleteMapping("/delete")
 		public ResponseEntity<?> deleteById(@RequestParam int h_id){
 			ResponseStructure<Hotel> htl = h_service.deleteById(h_id);
 			return new ResponseEntity<>(htl,HttpStatus.OK);
 		}
 		
 		
}
