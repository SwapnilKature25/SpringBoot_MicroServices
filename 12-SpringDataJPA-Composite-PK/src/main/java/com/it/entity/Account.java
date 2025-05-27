package com.it.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Account {   // will represent normal data. 
	private String holderName;
	private String branch;
	
	@EmbeddedId    // embeddedId is representing the class which are having all the primary keys.
	private AccountPK accountPk;
//	If we are having single column as PK then we can go for @Id annotation.
//	If we want to represent more than one primary key in the table for all the primary will create one class. (i.e AccountPK) 

	
	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public AccountPK getAccountPk() {
		return accountPk;
	}

	public void setAccountPk(AccountPK accountPk) {
		this.accountPk = accountPk;
	}

	@Override
	public String toString() {
		return "Account [holderName=" + holderName + ", branch=" + branch + ", accountPk=" + accountPk + "]";
	}
	
	
	
	
}

