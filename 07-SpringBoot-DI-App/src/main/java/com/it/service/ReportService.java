package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.it.dao.IReportDao;
import com.it.dao.ReportDaoImpl;

@Service
public class ReportService {
	@Value("${report.type}")
	private String type;
	
//	@Autowired
	private IReportDao reportDao;
	
//	public ReportService() {
//		System.out.println("0-param constructor");
//	}
	
	// recommended
	@Autowired   
	public ReportService(ReportDaoImpl reportDao) {
		System.out.println("Param - constructor");
		this.reportDao=reportDao;
	}
	
//	@Autowired
//	public void setReportDao(ReportDao reportDao)
//	{
//		System.out.println("setReportDao() called");
//		this.reportDao=reportDao;
//	}
	
	public void printName(Integer userId)
	{
		System.out.println("Report type : "+type);
		String nameById = reportDao.getNameById(userId);
		System.out.println(nameById);
	}
}
