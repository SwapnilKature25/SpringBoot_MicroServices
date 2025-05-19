package com.it.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoImpl implements IReportDao
{
	public ReportDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNameById(Integer userId) {
		if(userId == 100)
			return "John";
		else if(userId == 101)
			return "Smith";
		else 
			return "Name not found";
	}
}
