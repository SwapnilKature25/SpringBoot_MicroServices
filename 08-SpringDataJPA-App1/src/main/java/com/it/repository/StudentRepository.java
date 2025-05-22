package com.it.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.it.entity.Student;

//@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>
{
	// select * from student_dtls where student_gender=:gender
	public List<Student> findByGender(String gender);    // based on the method name JPA will construct the query
	
	// select * from student_dtls where student_gender is null;
	public List<Student> findByGenderIsNull();
	
	// JPA will internally create above query as : 
	// select * from student_dtls where student_rank >= :rank;
	public List<Student> findByRankGreaterThanEqual(Integer rank);
	
	// select * from sstudent_dtls where student_rank <= : rank
	public List<Student> findByRankLessThanEqual(Integer rank);  
	
	// male students who are having rank >= 100
	// select * from student_dtls where student_gender=? and student_rank >= : rank;
	public List<Student> findByGenderAndRankGreaterThanEqual(String gender,Long rank);
	
	
}
