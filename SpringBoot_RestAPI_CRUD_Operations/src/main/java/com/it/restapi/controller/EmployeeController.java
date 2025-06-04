package com.it.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.it.restapi.entity.Employee;
import com.it.restapi.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;
	
	// to get all the employees use get mapping
//	The @GetMapping annotation in Spring is used to handle HTTP GET requests in RESTful web services.
//	url - GET : localhost:8080/employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> employees = repo.findAll();
		return employees;
	}
	
//	url - GET : localhost:8080/getemployee/1
	@GetMapping("/getemployee/{id}")   // we are passing id as path variable 
	public Employee getEmployee(@PathVariable Integer id) {
		Employee employee = repo.findById(id).get();
		return  employee;
	}
	
//	to create new emp use post mapping
//	url - POST : localhost:8080/employee/add
	@PostMapping("/employee/add")     // here the emp will be added but it will show 200 ok in postman but it should show 201 ok so for that use below annotation.
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createEmployee(@RequestBody Employee emp) {
		repo.save(emp);
	}
	
//	used to update
//	url - PUT : localhost:8080/employee/update/3
	@PutMapping("/employee/update/{id}")
	public Employee updatedEmployee(@PathVariable Integer id) {
		Employee employee = repo.findById(id).get();
		employee.setEmpDesg("Tester");
		employee.setEmpSal(20000.0);
		repo.save(employee);
		return employee;
	}
	
//	to delete record 
//	url - DELETE : localhost:8080/employee/delete/3
	@DeleteMapping("/employee/delete/{id}")
	public void removeEmployee(@PathVariable Integer id) {
		repo.deleteById(id);   // way1
//		Employee emp = repo.findById(id).get();  // fetching emp with given id then deleting
//		repo.delete(emp);		// way 2
	}
	
	
	
	
}
