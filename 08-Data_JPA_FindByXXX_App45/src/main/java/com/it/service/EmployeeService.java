package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.Employee;
import com.it.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository empRepo) {
		System.out.println("EmployeeService.EmployeeService() called");
		this.employeeRepository=empRepo;
	}
	
	public void saveEmployee() {
		Employee emp=new Employee();
		emp.seteId(124);
		emp.seteName("Smith");
		emp.seteSal(45000.0);
		emp.seteGen("Male");
		emp.seteCountry("UK");
		employeeRepository.save(emp);		
	}
	
	public void getAllEmps() {
		Iterable<Employee> emps = employeeRepository.findAll();
//		emps.forEach(System.out::println);
		emps.forEach( e->{
			System.out.println(e);
		});
		
	}
	
	public void getEmpsWithCountry() {
		List<Employee> emps= employeeRepository.findByECountry("India");
		emps.forEach(System.out::println);
		
	}
	
	public void getEmpsWithGender() {
		List<Employee> emps= employeeRepository.findByEGen("Male");
		emps.forEach(System.out::println);
		
	}
	
	public void getEmpsWithGenderAndCountry() {
		List<Employee> emps= employeeRepository.findByEGenAndECountry("Male","India");
		emps.forEach(System.out::println);
	}

	public void getEmpsBasedOnSalary() {
		List<Employee> emps= employeeRepository.findByESalGreaterThan(40000.0);
		emps.forEach(System.out::println);
	}
	
}
