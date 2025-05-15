package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.it.cfg.AppConfig;
import com.it.reports.IReport;

//@Service
@Service("reportService")    //optional
public class ReportService {

    private final AppConfig appConfig;
	
	@Autowired       // field injection
	@Qualifier("pdf")
	private IReport report;

    ReportService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
	
	public void generate() {
		System.out.println("Injected :: "+report.getClass().getName());
		report.generateReport();
	}
	
}
