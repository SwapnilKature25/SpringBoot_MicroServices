package com.it.entity;

import jakarta.persistence.Embeddable;

@Embeddable   // the class which are having all keys as primary keys then it is represented by @Embeddable annotation
public class AccountPK {  // it will represent only PK of the account

	private Integer accId;
	private String accType;
	private Long accNum;
	
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public Long getAccNum() {
		return accNum;
	}
	public void setAccNum(Long accNum) {
		this.accNum = accNum;
	}
	@Override
	public String toString() {
		return "AccountPK [accId=" + accId + ", accType=" + accType + ", accNum=" + accNum + "]";
	}

	
	
}
