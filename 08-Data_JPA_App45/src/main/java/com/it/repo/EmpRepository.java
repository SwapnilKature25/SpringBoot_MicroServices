package com.it.repo;

import org.springframework.data.repository.CrudRepository;

import com.it.entity.Employee;

public interface EmpRepository extends CrudRepository<Employee, Integer>
{
	
}
