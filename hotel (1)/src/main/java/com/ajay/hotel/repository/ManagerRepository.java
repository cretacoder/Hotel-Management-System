package com.ajay.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.hotel.entity.Manager;
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
