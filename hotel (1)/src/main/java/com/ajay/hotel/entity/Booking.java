package com.ajay.hotel.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Booking {
	@Id
	@GeneratedValue
	private int b_id;
	
	private LocalDateTime check_in_date;
	private LocalDateTime check_out_date;
	private int no_people;
	private int rating;
	
	@ManyToOne
	private Customer customer;
	@OneToOne
	private Room room;
}