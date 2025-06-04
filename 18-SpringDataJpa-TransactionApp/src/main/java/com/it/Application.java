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
//		service.saveData();
		service.deleteEmployeeAndAddresses(9);
	}

}

/*
Hibernate: insert into emp_tbl (emp_name,emp_sal) values (?,?)
Hibernate: insert into emp_addr_tbl (city,country,emp_id,state,type) values (?,?,?,?,?)


*/