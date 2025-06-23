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

import com.ajay.hotel.entity.Customer;
import com.ajay.hotel.response.ResponseStructure;
import com.ajay.hotel.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	CustomerService c_service;
	
	@PostMapping("/register")
	ResponseEntity<?>register(@RequestBody Customer cmr){
		ResponseStructure<Customer> cmr1=c_service.register(cmr);
		return new ResponseEntity<>(cmr1,HttpStatus.CREATED);
	}
	@GetMapping("/getById")
		public ResponseEntity<?> getCmrById (@RequestParam int c_id){
			Optional<Customer> cmr = c_service.getCmrById(c_id);
			return new ResponseEntity<>(cmr,HttpStatus.FOUND);
		}
		@GetMapping("/getAllCmr")
		public ResponseEntity<?>getAllCmr(){
				List<Customer> cmr = c_service.getAllCmr();
			return new ResponseEntity<>(cmr,HttpStatus.FOUND);
		}
		@PutMapping("/updateById")
		public ResponseEntity<?> updateById (@RequestParam int c_id,@RequestBody Customer cmr){
			ResponseStructure<Customer> cmr1 = c_service.updateById(c_id, cmr);
			return new ResponseEntity<>(cmr1,HttpStatus.OK);
		}
		@DeleteMapping("/delete")
		public ResponseEntity<?> deleteById(@RequestParam int c_id){
			ResponseStructure<Customer> cmr = c_service.deleteById(c_id);
			return new ResponseEntity<>(cmr,HttpStatus.OK);
		}
}
