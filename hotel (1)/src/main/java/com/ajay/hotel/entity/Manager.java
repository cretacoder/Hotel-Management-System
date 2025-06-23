package com.ajay.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Manager {
	@Id
	private int manager_id;
	private String admin_name;
	private String admin_email;
	private String admin_password;
	@OneToOne
	private Hotel hotel;
}
