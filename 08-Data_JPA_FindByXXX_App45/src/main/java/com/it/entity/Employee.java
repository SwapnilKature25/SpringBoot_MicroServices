package com.it.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity		
@Table(name="Emp")
public class Employee {
	
	@Id	
	private Integer eId;
	private String eName;
	private Double eSal;
	private String eGen;
	private String eCountry;
	
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public Double geteSal() {
		return eSal;
	}
	public void seteSal(Double eSal) {
		this.eSal = eSal;
	}
	public String geteGen() {
		return eGen;
	}
	public void seteGen(String eGen) {
		this.eGen = eGen;
	}
	public String geteCountry() {
		return eCountry;
	}
	public void seteCountry(String eCountry) {
		this.eCountry = eCountry;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSal=" + eSal + ", eGen=" + eGen + ", eCountry="
				+ eCountry + "]";
	}
	
	
	
}	
