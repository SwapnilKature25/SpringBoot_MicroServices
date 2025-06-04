package com.it.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.restapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{

}
