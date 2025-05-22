package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.it.entity.Student;

//@Repository    // optional
public interface StudentRepository extends CrudRepository<Student, Integer>
{
//	by native SQL Query  means direct SQL query we want to execute.
	@Query(value = "select * from student_dtls", nativeQuery = true)   // if we write nativeQuery as true it will understand that we are writing plane sql query [ directly it will execute in the database ] 
	public List<Student> getAllStudents();
	
//	by HQL Query
	@Query("from Student")  // means from student entity, student entity belongs to student_dtls table.
	public List<Student> getStudents();

// 1] SQL :   select * from student_dtls where student_gender=:gender	
	@Query(value="select * from student_dtls where student_gen=:gender", nativeQuery = true)
	public List<Student> getStudentsGender(String gender);
	
	@Query("from Student where gender=:gender")
	public List<Student> getStudGender(String gender);
	
//	2] SQl :  select * from student_dtls where student_gender is null	
	@Query(value="select * from student_dtls where student_gen is null", nativeQuery = true)
	public List<Student> getStudGenNull();
		
	@Query("from Student where gender is null")
	public List<Student> getStudGenIsNull();
	
//	3] SQL : select * from student_dtls where student_rank >= : rank	
	@Query(value="select * from student_dtls where student_rank >= :rank", nativeQuery = true)
	public List<Student> getStudentHighRank(Long rank);
	
	@Query("from Student where rank >= :rank")
	public List<Student> getStudentsHighRank(Long rank);
	
	
//	4] SQL :  select * from student_dtls where student_gender=:gender and student_rank >= :rank
	@Query(value="select * from student_dtls where student_gen=:gender and student_rank >= :rank", nativeQuery = true)
	public List<Student> getStudentGenderAndRank(String gender,Long rank);
	
	@Query("from Student where gender=:gender and rank>= :rank")
	public List<Student> getStdGenAndRank(String gender, Long rank);
	
//	5] SQL : select  student_rank, student_gender from student_dtls
//	@Query(value="select Student_rank, student_gen from student_dtls", nativeQuery = true)
	@Query("select rank,gender from Student")
	public List<Object[]> getStdRankGender();
	
}
