package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.entity.Employee;
import com.it.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmployeeService service = context.getBean(EmployeeService.class);

//		service.getEmps();
		System.out.println();
//		service.getEmpsSQL();
		
//		service.updateEmpsCntry();

//		service.updateEmpCountry(121, "USA");
//		System.out.println();
//		service.getEmps();
//		service.deleteEmpsByCountry("USA");
		
//		service.getSortedEmps();
		
		
		// Pagination
		// for end user page will start from 1 and for database it will start from 0
		service.getEmpsWithPagination(1);
		 
		System.out.println();
		
		// QBE
		Employee emp=new Employee();
		emp.seteCountry("India");
		emp.seteGen("Male");
		// whatever we add to emp object that will be added to where clause 
		service.getEmpsWithQBE(emp);
		
	}
}
