package com.it.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.it.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	
	//  select * from emp where emp_ctry=’India’;
	public List<Employee> findByECountry(String country);
	
	//  select * from emp where emp_gen=’Male’;
	public List<Employee> findByEGen(String gender);

	//  select * from emp where emp_gen=’Male’ AND emp_ctry='India';
	public List<Employee> findByEGenAndECountry(String gender,String country);

	//  select * from emp where emp_sal > 40000;
	public List<Employee> findByESalGreaterThan(Double salary);
	
}
 