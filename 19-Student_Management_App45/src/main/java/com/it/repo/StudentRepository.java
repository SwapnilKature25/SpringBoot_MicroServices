package com.it.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
