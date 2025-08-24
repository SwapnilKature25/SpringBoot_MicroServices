package com.client.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClientDTO {
	
	@NotEmpty(message = "The First Name is required")
	private String firstName;

	@NotEmpty(message = "The Last Name is required")
	private String lastName;

	@NotEmpty(message = "The Email is required")
	@Email
	private String email;

	private Long phone;
	private String address;
	
	@NotEmpty(message = "The Status is required")
	private String status;  // New, Permanent, Lead, Occasional, Inactive
	
}
