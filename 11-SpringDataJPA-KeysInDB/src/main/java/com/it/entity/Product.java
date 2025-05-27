package com.it.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity
// table annotation is optional if we don't specify table annotation it will take class name as table name.
public class Product {
//	 recommended wrapper classes as datatype
	@Id    // it will represent it as a primary key column.
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
//	@SequenceGenerator(name="pid", sequenceName="pid_seq")   // sequenceName is the actual sequence created in the DB
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pid")    // it is not supported in mysql, it is used in the sequence supported DB. 
//	generator : generators are used to generate the value for primary key column 

	@TableGenerator(initialValue=100, name="pid", table="pid_seq_tbl")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="pid")    
	private Integer productId;   // null
	private String productName;   // null
	private Double productPrice;  // null
//	not recommended
//	private int productId;   // 0
//	private String productName;   // null
//	private double productPrice;  // 0.0
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	
	
	
}
