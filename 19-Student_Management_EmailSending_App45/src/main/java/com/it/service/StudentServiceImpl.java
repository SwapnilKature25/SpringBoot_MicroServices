package com.it.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.it.entity.Student;
import com.it.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repo;
	
	private EmailService emailService;
	
	
	public StudentServiceImpl(StudentRepository studentRepository, EmailService emailService) {
		this.repo=studentRepository;
		this.emailService=emailService;
	}
	
	@Override
	public boolean saveStudent(Student s) {
		Student savedStudent = repo.save(s);
		
		String subject = "Student Registration";
		String body= "<h1>Your account created in Student Management website</h1><br><h2>Welcome to Ashok IT</h2>";
		emailService.sendEmail2(subject, body, s.getEmail());
	
		return savedStudent.getSid() != null;
	}

	@Override
	public List<Student> getAllStudents() {
//		 List<Student> findAll = repo.findAll();
//		 return findAll;
		return repo.findAll();
	}

	@Override
	public void deleteStd(Integer sid) {
		repo.deleteById(sid);
		
	}
	

}
