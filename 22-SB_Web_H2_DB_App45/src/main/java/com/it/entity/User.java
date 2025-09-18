package com.it.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user_master")
public class User {
	
	// for alpha-numeric id go for AUTO
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	
	@NotNull(message="Name is mandatory")
	@Size(min=3, max=8, message="Min 3 and Max 8 chars allowed")
	private String fullName;
	@Column(unique=true)
	@Email(message="Enter valid Email")
	@NotNull(message="Email is mandatory")
	private String email;

	@NotNull(message="Password is mandatory")
	private String pwd;

	private Long phno;
	
	@CreationTimestamp
	private LocalDateTime createdDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", fullName=" + fullName + ", pwd=" + pwd + ", email=" + email + ", phno=" + phno
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	
}
