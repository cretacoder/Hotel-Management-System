package com.ajay.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.hotel.entity.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}
