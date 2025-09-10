package com.it;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.it.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	 /**
     * CommandLineRunner will run after application startup.
     * It calls EmployeeService to read CSV and save into DB.
     */
    @Bean
    CommandLineRunner run(EmployeeService service) {
        return args -> {
            String filePath = "src/main/resources/employees.csv"; // CSV file path
            service.saveEmployeesFromCsv(filePath);
        };
    }

}
