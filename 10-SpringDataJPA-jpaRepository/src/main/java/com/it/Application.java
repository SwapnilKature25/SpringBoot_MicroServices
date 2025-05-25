package com.it;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.it.entity.Student;
import com.it.repository.StudentRepository;

@SpringBootApplication
public class Application {

    private final StudentRepository studentRepository;

    Application(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
	
//		1
//		Iterable<Student> findAll = studentRepository.findAll();
//		findAll.forEach(System.out::println);
		
//		2  => Pagination concept
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter page number : ");
		int pageNo = sc.nextInt();
		int pageSize=3;
//		page no. will start from 0
		PageRequest pageReq = PageRequest.of(pageNo-1, pageSize);    // page 0 means page 1    // pageNo-1 it means we have to start from 0 i.e page 1
		org.springframework.data.domain.Page<Student> page = studentRepository.findAll(pageReq);
		List<Student> students=page.getContent();
		students.forEach(System.out::println);
	
	
//		3  - sorting
		
//		List<Student> stds = studentRepository.findAll(Sort.by("gender"));		/// sorting based on gender,name,...
		List<Student> stds = studentRepository.findAll(Sort.by("gender").descending());		/// sorting based on gender,name,...
		stds.forEach(System.out::println);
	
	
	
	
	}
}

/*
1
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=104, name=Jane, gender=Female, rank=11]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=106, name=Max, gender=Female, rank=113]
Student [id=111, name=Jax, gender=null, rank=121]
Student [id=112, name=Raja, gender=Male, rank=12]

2
Enter page number : 
1
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 limit ?,?
Hibernate: select count(s1_0.student_id) from student_dtls s1_0
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=104, name=Jane, gender=Female, rank=11]
Student [id=105, name=Mike, gender=Male, rank=112]

Enter page number : 
2
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 limit ?,?
Hibernate: select count(s1_0.student_id) from student_dtls s1_0
Student [id=106, name=Max, gender=Female, rank=113]
Student [id=111, name=Jax, gender=null, rank=121]
Student [id=112, name=Raja, gender=Male, rank=12]


3 
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 order by s1_0.student_gen
Student [id=111, name=Jax, gender=null, rank=121]
Student [id=104, name=Jane, gender=Female, rank=11]
Student [id=106, name=Max, gender=Female, rank=113]
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=112, name=Raja, gender=Male, rank=12]

*/