package com.ajay.hotel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.hotel.dao.CustomerDao;
import com.ajay.hotel.entity.Customer;
import com.ajay.hotel.exception.InvalidCmrIdException;
import com.ajay.hotel.repository.CustomerRepository;

import com.ajay.hotel.response.ResponseStructure;

@Service
public class CustomerService {

	@Autowired 
	CustomerDao c_dao;
	@Autowired
	CustomerRepository c_repo;
	public ResponseStructure<Customer> register(Customer cmr) {
		Customer cmr1 = c_dao.register(cmr);

		ResponseStructure<Customer> str = new ResponseStructure<Customer>();
		str.setData(cmr1);
		str.setTimeStamp(LocalDateTime.now());
		str.setMessage("register Succesfully");
		str.setStatusCode(201);
		return str;
	}
	public Optional<Customer> getCmrById(int c_id) {
		Optional<Customer> cmr = c_dao.getCmrById(c_id);
		if(cmr.isPresent()) {
			return cmr;
		}else {
			throw new InvalidCmrIdException();
		}

	}

	public List<Customer> getAllCmr() {
		List<Customer> cmr = c_dao.getAllCmr();
		if (cmr!=null) {
			return cmr;
		}
		else {
			throw new IllegalArgumentException("Customer is empty pls add the Customer");
		}
	}

	public ResponseStructure<Customer> updateById(int c_id,Customer cmr) {
		Optional<Customer> cmr1 = c_dao.updateById(c_id);
		if(cmr1.isPresent()) {
			Customer cmr2 = cmr1.get();
			cmr2.setC_name(cmr.getC_name());
			cmr2.setC_email(cmr.getC_email());
			cmr2.setC_address(cmr.getC_address());
			cmr2.setC_password(cmr.getC_password());
			cmr2.setC_phone(cmr.getC_phone());
			cmr2.setC_aadhar(cmr.getC_aadhar());
			Customer saveUpdate = c_dao.register(cmr2);
			ResponseStructure<Customer> str = new ResponseStructure<Customer>();
			str.setData(saveUpdate);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("update Succesfully");
			str.setStatusCode(200);
			return str;

		}
		else {
			throw new IllegalArgumentException("no object check c_id");
		}
	}


	public ResponseStructure<Customer> deleteById(int c_id) {
		Optional<Customer> del=c_dao.delete(c_id);

		if(del.isPresent()) {
			Customer cmr = del.get();
			c_repo.delete(cmr);
			ResponseStructure<Customer> str =new ResponseStructure<Customer>();
			str.setData(cmr);
			str.setTimeStamp(LocalDateTime.now());
			str.setMessage("Customer Name: "+cmr.getC_name()+"  Deleted Succesfully");
			str.setStatusCode(200);
			return str;
		}
		else {
			throw new IllegalArgumentException("This ID is not Present, Check Id");
		}

	}

}
