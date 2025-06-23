package com.ajay.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Room {
	@Id
	private  int room_id;
	private String room_no;
	private String room_type;
	private String room_price;
	private int no_beds;
	private int max_people;
	private String availablity;
	
	@OneToOne(mappedBy = "room")
	@JsonIgnore
	private Booking book;
	
	@ManyToOne
	private Hotel hotel;
}
