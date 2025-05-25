package com.it;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.entity.Student;
import com.it.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
//		1
//		List<Student> students = studentRepository.getAllStudents();
//		1
//		List<Student> students = studentRepository.getStudents();
//		students.forEach(System.out::println);
		
//		2
//		List<Student> gender = studentRepository.getStudentsGender("Male");
//		List<Student> gender = studentRepository.getStudGender("Male");
//		gender.forEach(System.out::println);
		
//		3
//		List<Student> genNull = studentRepository.getStudGenIsNull();
//		genNull.forEach(System.out::println);
	
//		4
//		List<Student> highRank = studentRepository.getStudentHighRank(100l);
//		List<Student> highRank = studentRepository.getStudentsHighRank(100l);
//		highRank.forEach(System.out::println);
	
		
//		5
//		List<Student> studentGenderAndRank = studentRepository.getStudentGenderAndRank("Male", 50l);
//		List<Student> studentGenderAndRank = studentRepository.getStdGenAndRank("Male", 50l);		
//		studentGenderAndRank.forEach(System.out::println);
	
		
//		6
		List<Object[]> stdRankGender = studentRepository.getStdRankGender();
//		stdRankGender.forEach(System.out::println);   // it will print only address of objects
		stdRankGender.forEach(row -> System.out.println("Rank: " + row[0] + ", Gender: " + row[1]));

	}

}


/* 1 
 
Hibernate: select * from student_dtls 
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=104, name=Jane, gender=Female, rank=11]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=106, name=Max, gender=Female, rank=113]
Student [id=112, name=Raja, gender=Male, rank=12]

1
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=104, name=Jane, gender=Female, rank=11]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=106, name=Max, gender=Female, rank=113]
Student [id=112, name=Raja, gender=Male, rank=12]


2
Hibernate: select * from student_dtls where student_gen=?
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=112, name=Raja, gender=Male, rank=12]

2
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_gen=?
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=112, name=Raja, gender=Male, rank=12]

3
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_gen is null
Student [id=111, name=Jax, gender=null, rank=121]

4
Hibernate: select * from student_dtls where student_rank >= ?
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=106, name=Max, gender=Female, rank=113]
Student [id=111, name=Jax, gender=null, rank=121]

Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_rank>=?
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=106, name=Max, gender=Female, rank=113]
Student [id=111, name=Jax, gender=null, rank=121]

5] 
Hibernate: select * from student_dtls where student_gen=? and student_rank >= ?
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=105, name=Mike, gender=Male, rank=112]

Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_gen=? and s1_0.student_rank>=?
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=105, name=Mike, gender=Male, rank=112]


6] 
Hibernate: select s1_0.student_rank,s1_0.student_gen from student_dtls s1_0
Rank: 111, Gender: Male
Rank: 11, Gender: Female
Rank: 112, Gender: Male
Rank: 113, Gender: Female
Rank: 121, Gender: null
Rank: 12, Gender: Male


 */