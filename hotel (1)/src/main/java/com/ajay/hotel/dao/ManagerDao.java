package com.ajay.hotel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajay.hotel.entity.Manager;
import com.ajay.hotel.repository.ManagerRepository;

@Component
public class ManagerDao {
	@Autowired
	ManagerRepository MgrRepo;


	public Manager register(Manager mgr) {
		return MgrRepo.save(mgr);
	}

	public Optional<Manager> getMgrById(int manager_Id) {
		return MgrRepo.findById(manager_Id);	
	}
	public List<Manager> getAllMgr() {
		return MgrRepo.findAll();
	}

	public Optional<Manager> updateById(int manager_Id) {
		return MgrRepo.findById(manager_Id);
	}

	public Optional<Manager> delete(int manager_Id) {
		return MgrRepo.findById(manager_Id);


	}
}
