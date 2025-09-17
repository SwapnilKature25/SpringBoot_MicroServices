package com.it.service;

import java.util.List;

import com.it.entity.Student;


public interface StudentService {

	public boolean saveStudent(Student s);
	
	public List<Student> getAllStudents();
	
	public void deleteStd(Integer sid);
	
}
