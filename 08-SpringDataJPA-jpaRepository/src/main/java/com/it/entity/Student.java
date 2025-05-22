package com.it.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student_Dtls")   // optional
public class Student {
	@Id    // to make id as primary key
	@Column(name="Student_id")    // optional if column name and variable name are same
	private Integer id;
	@Column(name="Student_name")
	private String name;
	@Column(name="Student_gen")
	private String gender;
	@Column(name="Student_rank")
	private Long rank;
	
	public Student() {
	}
		
	
	public Student(Integer id, String name, String gender, Long rank) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.rank = rank;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", rank=" + rank + "]";
	}
	
	
	
}
