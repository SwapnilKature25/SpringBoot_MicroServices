package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.it.entity.Student;

import jakarta.transaction.Transactional;

//@Repository    // optional
public interface StudentRepository extends JpaRepository<Student, Integer>
{
	//  Note : whenever we are performing any non-select operation through custom query we need to enable/use Modifying and  transactional annotation.
		
//		for select operation transaction is not required but for non-select transactional is required.
//		Assignment questions : delete student using HQL  ( :sid called as named positional parameter)
		@Query("delete from Student where id=:sid")
		@Modifying   // it will represent this method is performing DML operations.
		@Transactional  // it will represent JPA need to take care of the transaction required for this method.
		public void deleteStudent(Integer sid);	

		@Query("update Student set gender=:gender where id=:sid")
		@Modifying 
		@Transactional
		public void updateStudent(Integer sid,String gender);
		
//		we can't do insertion directly with Custom HQL query, it is not possible -> we need to go for native SQL  (( but here it is runnig by both the methods ))
//		@Query(value="insert into Student_dtls(student_id,student_name,student_gen,student_rank) values(:sid,:name,:gender,:rank)", nativeQuery = true)  // native sql query
		@Query("insert into Student(id,name,gender,rank) values(:sid,:name,:gender,:rank)")    // HQL query
		@Modifying 
		@Transactional
		public void insertStudent(Integer sid,String name,String gender,Long rank);
		
		@Query("from Student")
		public List<Student> getAllStds();

			
		
		
}
