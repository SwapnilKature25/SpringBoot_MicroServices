package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmployeeService service = context.getBean(EmployeeService.class);
//		service.saveEmployee();
//		service.getAllEmps();
		
//		service.getEmpsWithCountry();
//		service.getEmpsWithGender();
		
//		service.getEmpsWithGenderAndCountry();
		service.getEmpsBasedOnSalary();
	}
//	08-Data_JPA_CustomQueries_App45
}
