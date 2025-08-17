package com.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Student {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long studentId;
	
	@Column(name="std_name", length=100, unique = true)
	private String name;
	private String college;
	private String location;
	private boolean active=true;
	
	@Lob
	private String about;
	
}
