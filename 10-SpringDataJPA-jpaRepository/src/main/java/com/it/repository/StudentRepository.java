package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Student;

//@Repository    // optional
public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
