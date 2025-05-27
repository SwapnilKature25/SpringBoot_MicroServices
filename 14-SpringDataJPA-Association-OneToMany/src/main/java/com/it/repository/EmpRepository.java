package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>
{

}
