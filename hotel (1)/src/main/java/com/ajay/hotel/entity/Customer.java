package com.ajay.hotel.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	private int c_id;
	@NotBlank(message = "Name is mandatory")
	@Pattern(regexp="^[A-Za-z ]*$")
	@Size(min=3,max=20)
	private String c_name;
	private String c_address;
	@Email
	private String c_email;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")
	private String c_password;
	@Min(6000000000L)  // Smallest 10-digit number
	@Max(9999999999L) // Largest 10-digit number
	private long c_phone;
	private String c_aadhar;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Booking>bookings;
}
