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

import com.ajay.hotel.entity.Hotel;
import com.ajay.hotel.entity.Manager;
import com.ajay.hotel.response.ResponseStructure;
import com.ajay.hotel.service.ManagerService;

@RestController
@RequestMapping("/Manager")
public class ManagerController {
	@Autowired
	ManagerService mgrService;
	
	@PostMapping("/register")
	ResponseEntity<?>register(@RequestBody Manager mgr,int hotel_Id){
		ResponseStructure<Manager> mgr1 = mgrService.register(mgr,hotel_Id);
		return new ResponseEntity<>(mgr1,HttpStatus.OK);
	}
	
		@GetMapping("/getById")
		public ResponseEntity<?> getMgrById (@RequestParam int manager_id){
			Optional<Manager> mgr = mgrService.getMgrById(manager_id);
			return new ResponseEntity<>(mgr,HttpStatus.FOUND);
		}
		
		@GetMapping("/getAllMgr")
		public ResponseEntity<?>getAllMgr(){
				List<Manager> mgr = mgrService.getAllMgr();
			return new ResponseEntity<>(mgr,HttpStatus.FOUND);
		}
		@PutMapping("/updateById")
		public ResponseEntity<?> updateById (@RequestParam int manager_id,@RequestBody Manager mgr){
			ResponseStructure<Manager> mgr1 = mgrService.updateById(manager_id, mgr);
			return new ResponseEntity<>(mgr1,HttpStatus.OK);
		}
		@DeleteMapping("/delete")
		public ResponseEntity<?> deleteById(@RequestParam int manager_id){
			ResponseStructure<Manager> message = mgrService.deleteById(manager_id);
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
	
	
	
	
	
}
