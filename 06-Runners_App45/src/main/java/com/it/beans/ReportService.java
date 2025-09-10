package com.it.beans;

import com.it.Application;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ReportService {

    private final Application application;
	
	public ReportService(Application application) {
		System.out.println("ReportService.ReportService()");
		this.application = application;
	}
	
	@PostConstruct  // method name can be anything
	public void initMeth() {
		// when the spring object is created if we want to execute some logic then we can place it here 
		System.out.println("ReportService.init() called");
	}
	
	@PreDestroy
	public void destroy() {
		// Before  spring object is removed from container and if we want to execute some logic then we can place it here 		
		System.out.println("ReportService.destroy() called");
	}
}
