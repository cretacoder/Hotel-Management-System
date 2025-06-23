package com.ajay.hotel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajay.hotel.entity.Customer;
import com.ajay.hotel.repository.CustomerRepository;
@Component
public class CustomerDao {
	@Autowired
	CustomerRepository c_repo;
	
		public Customer register(Customer cmr) {
			return c_repo.save(cmr);
			
		}
		public Optional<Customer> getCmrById(int c_id) {
			return c_repo.findById(c_id);
		}
		public List<Customer> getAllCmr() {
			return c_repo.findAll();
		}
		
		public Optional<Customer> updateById(int c_id) {
			return c_repo.findById(c_id);
		}

		public Optional<Customer> delete(int c_id) {
			return c_repo.findById(c_id);

	    }
}
