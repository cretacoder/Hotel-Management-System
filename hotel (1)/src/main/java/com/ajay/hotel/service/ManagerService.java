package com.ajay.hotel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.hotel.dao.ManagerDao;
import com.ajay.hotel.entity.Hotel;
import com.ajay.hotel.entity.Manager;
import com.ajay.hotel.exception.InvalidMgrIdException;
import com.ajay.hotel.repository.HotelRepository;
import com.ajay.hotel.repository.ManagerRepository;
import com.ajay.hotel.response.ResponseStructure;


@Service
public class ManagerService {
		@Autowired
		ManagerRepository mgrRepo;
		@Autowired
		ManagerDao mgrDao;
		@Autowired
		HotelRepository h_repo;
		
		
		
	public ResponseStructure<Manager> register(Manager mgr, int hotel_Id) {
				Optional<Hotel> htl=h_repo.findById(hotel_Id);
				Hotel hotel = htl.get();
				mgr.setHotel(hotel);
				Manager	mgr1=mgrDao.register(mgr);
				ResponseStructure<Manager> str = new ResponseStructure<Manager>();
				str.setData(mgr1);
				str.setTimeStamp(LocalDateTime.now());
				str.setMessage("Mgr register Succesfully");
				str.setStatusCode(201);
				return str;
	}

	public Optional<Manager> getMgrById(int manager_Id) {
		Optional<Manager> mgr = mgrDao.getMgrById(manager_Id);
		if(mgr.isPresent()) {
			return mgr;
		}else {
			throw new InvalidMgrIdException();
		}

	}
	
	public List<Manager> getAllMgr() {
		List<Manager> emp = mgrDao.getAllMgr();
		if (emp!=null) {
		return emp;
		}
		else {
		throw new IllegalArgumentException("Employee is empty pls add the employee");
		}
	}

	public ResponseStructure<Manager> updateById(int manager_Id,Manager mgr) {
		Optional<Manager> message = mgrDao.updateById(manager_Id);
		if(message.isPresent()) {
			Manager mgr1 = message.get();
			
			mgr1.setAdmin_name(mgr.getAdmin_name());
			mgr1.setAdmin_email(mgr.getAdmin_email());
			mgr1.setAdmin_password(mgr.getAdmin_password());
			Manager	mgr2=mgrDao.register(mgr1);
			
			ResponseStructure<Manager> str = new ResponseStructure<Manager>();
			str.setData(mgr2);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("Manager update Succesfully");
			str.setStatusCode(200);
			return str;

		}
		else {
			throw new IllegalArgumentException("no object check mgrId");
		}
	
	}

	public ResponseStructure<Manager> deleteById(int manager_Id) {
		Optional<Manager> del=mgrDao.delete(manager_Id);
		if(del.isPresent()) {
			Manager mgr = del.get();
			mgrRepo.delete(mgr);
			ResponseStructure<Manager> str =new ResponseStructure<Manager>();
			str.setData(mgr);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("Name  "+mgr.getAdmin_name()+"  Deleted Succesfully");
			str.setStatusCode(200);
			return str;
		}
		else {
			throw new IllegalArgumentException("Check Id");
		}
		
	}
	

}
