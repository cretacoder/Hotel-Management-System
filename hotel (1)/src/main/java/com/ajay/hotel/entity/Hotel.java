package com.ajay.hotel.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Hotel {
	@Id
	@GeneratedValue
	private int hotel_id;
	private String hotel_name;
	private String hotel_gst;
	private String hotel_address;
	private String hotel_manager;
	private String hotel_owner;
	private int hotel_rating;
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Room>room;
	
	@OneToOne(mappedBy = "hotel")
	@JsonIgnore
	private Manager manager;
}