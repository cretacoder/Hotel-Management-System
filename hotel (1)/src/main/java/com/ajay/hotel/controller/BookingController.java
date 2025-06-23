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

import com.ajay.hotel.entity.Booking;
import com.ajay.hotel.response.ResponseStructure;
import com.ajay.hotel.service.BookingService;

@RestController
@RequestMapping("/Booking")
public class BookingController {
	@Autowired
	BookingService bkService;
	
	@PostMapping("/register")
	ResponseEntity<?>register(@RequestBody Booking bk,@RequestParam int room_id,int customer_id){
		ResponseStructure<Booking> bk1 = bkService.register(bk,room_id,customer_id);
		return new ResponseEntity<>(bk1,HttpStatus.OK);
	}
	
		@GetMapping("/getById")
		public ResponseEntity<?> getBookingById (@RequestParam int b_id){
			Optional<Booking> bk = bkService.getBookingById(b_id);
			return new ResponseEntity<>(bk,HttpStatus.FOUND);
		}
		
		@GetMapping("/getAllBooking")
		public ResponseEntity<?>getAllBooking(){
				List<Booking> bk = bkService.getAllBooking();
			return new ResponseEntity<>(bk,HttpStatus.FOUND);
		}
		@PutMapping("/updateById")
		public ResponseEntity<?> updateById (@RequestParam int b_id,@RequestBody Booking bk){
			ResponseStructure<Booking> bk1 = bkService.updateById(b_id, bk);
			return new ResponseEntity<>(bk1,HttpStatus.OK);
		}
		@DeleteMapping("/delete")
		public ResponseEntity<?> deleteById(@RequestParam int b_id){
			ResponseStructure<Booking> bk = bkService.deleteById(b_id);
			return new ResponseEntity<>(bk,HttpStatus.OK);
		}
}
