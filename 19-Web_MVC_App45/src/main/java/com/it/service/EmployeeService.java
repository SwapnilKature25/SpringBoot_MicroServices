package com.it.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.it.model.Employee;
import com.it.repo.EmpRepository;

@Service
public class EmployeeService {
	
	private EmpRepository empRepository;
	
	public EmployeeService(EmpRepository empRepository) {
		this.empRepository=empRepository;
	}
	
	public List<Employee> getAllEmps() {
		return empRepository.findAll();
	}
}
