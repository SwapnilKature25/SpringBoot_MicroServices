package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.it.entity.Employee;
import com.it.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	private static final int pageSize=3;
	
	private EmployeeRepository empRepo;
	
	public EmployeeService(EmployeeRepository empRepo) {
		System.out.println("EmployeeService.EmployeeService() called");
		this.empRepo=empRepo;
	}
	
	/*
	public void getEmps() {
		List<Employee> allEmps = empRepo.getAllEmps();
		allEmps.forEach(System.out::println);
	} */

//	 Pagination
	public void getEmpsWithPagination(int pageNum) {
		
		Pageable page = PageRequest.of(pageNum-1, pageSize);
		
		Page<Employee> emps = empRepo.findAll(page);
		if(emps.isEmpty()) {
			System.out.println("No Record available");
		}else {
			emps.get().forEach(System.out::println);			
		}
	}
	
	
	
	
	public void getEmpsSQL() {
		List<Employee> empsSQL = empRepo.getEmpsSQL();
		empsSQL.forEach(System.out::println);
	}
	
	// Query By Example QBE
	public void getEmpsWithQBE(Employee emp) {
		Example<Employee> empEx = Example.of(emp);
		List<Employee> emps = empRepo.findAll(empEx);
		emps.forEach(System.out::println);
	}
	
	  // Update Country for employee
    public void updateEmpCountry(Integer id, String country) {
        int count = empRepo.updateEmpCountry(id, country);
        System.out.println(count + " record(s) updated successfully");
    }

    // Update Salary for employees by gender
    public void updateSalaryByGender(String gender, Double salary) {
        int count = empRepo.updateSalaryByGender(gender, salary);
        System.out.println(count + " record(s) updated successfully");
    }

    // Delete employees by country
    public void deleteEmpsByCountry(String country) {
        int count = empRepo.deleteByCountry(country);
        System.out.println(count + " record(s) deleted successfully");
    }

    // Delete employees by gender
    public void deleteEmpsByGender(String gender) {
        int count = empRepo.deleteByGender(gender);
        System.out.println(count + " record(s) deleted successfully");
    }
	
    
    public void getSortedEmps() {
    	// sorting based on emp Name
    	Iterable<Employee> emps = empRepo.findAll(Sort.by("eName").ascending());
    	emps.forEach(System.out::println);
    }
    
}
