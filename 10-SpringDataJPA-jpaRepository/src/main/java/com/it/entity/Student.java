package com.it.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

	@Column(name="ACTIVE_SW")
	private String activeSW;
	
//	 Timestamping in Data JPA
	@CreationTimestamp
	@Column(name="CREATED_DATE" , updatable=false)
	private LocalDateTime createDate;
//	 if we use LocalDateTime then it will give date + time and if we use LocalDate it will give only Date
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE" , insertable=false)
	private LocalDateTime updateDate;
	
	
	public Student() {
	}
		
	
	

	public Student(Integer id, String name, String gender, Long rank, String activeSW) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.rank = rank;
		this.activeSW = activeSW;
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


	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}


	public LocalDateTime getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}


	public String getActiveSW() {
		return activeSW;
	}


	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}
	
	
	
	
}
