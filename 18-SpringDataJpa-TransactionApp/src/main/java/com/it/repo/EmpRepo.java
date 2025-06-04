package com.it.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer>
{

}
