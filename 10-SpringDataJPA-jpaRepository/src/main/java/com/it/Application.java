package com.it;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
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
	
	
//		4  -- QueryByExample
		Student s=new Student();
		s.setGender("Male");
		s.setRank(111l);
		Example<Student> example = Example.of(s);
		List<Student> studs = studentRepository.findAll(example);   // if findAll() is empty i.e if there is no data in entity class then it will print all content.
		studs.forEach(System.out::println);
		
		
		
//		assignment : deleting a student
		studentRepository.deleteStudent(112);
		System.out.println("Student deleted...");

//		updating a record in table
		studentRepository.updateStudent(111, "Male");
		System.out.println("Updated...");
		
//		inserting record
//		studentRepository.insertStudent(123, "Snoop", "Male", 170l);
//		System.out.println("Inserted...");
		
//		fetch all
		List<Student> allStds = studentRepository.getAllStds();
		allStds.forEach(System.out::println);
	

//		* Timestamping in Data JPA + soft and hard delete
		Student s2 = new Student(2, "Rani","Female",125l,"Y");
		studentRepository.save(s2);
		System.out.println("Record saved...");
	
		// soft delete i.e making data inactive
		Student student = studentRepository.findById(2).get();
		student.setActiveSW("N");
		studentRepository.save(student);
//		Hibernate: update student_dtls set active_sw=?,student_gen=?,student_name=?,student_rank=?,updated_date=? where student_id=?

		
		
		
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


4   -- 1 condition 
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_gen=?
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=112, name=Raja, gender=Male, rank=12]

-- 2 condition
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_gen=? and s1_0.student_rank=?
Student [id=103, name=Allen, gender=Male, rank=111]

-- if enitiy class doesn't contain data then it will fetch all data
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=104, name=Jane, gender=Female, rank=11]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=106, name=Max, gender=Female, rank=113]
Student [id=111, name=Jax, gender=null, rank=121]
Student [id=112, name=Raja, gender=Male, rank=12]


// delete
Hibernate: delete s1_0 from student_dtls s1_0 where s1_0.student_id=?
Student deleted...

// update
Hibernate: update student_dtls s1_0 set student_gen=? where s1_0.student_id=?
Updated...

// inserted
Hibernate: insert into student_dtls(student_id,student_name,student_gen,student_rank) values (?,?,?,?)
Inserted...

// fetch all
Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0
Student [id=103, name=Allen, gender=Male, rank=111]
Student [id=104, name=Jane, gender=Female, rank=11]
Student [id=105, name=Mike, gender=Male, rank=112]
Student [id=106, name=Max, gender=Female, rank=113]
Student [id=111, name=Jax, gender=Male, rank=121]
Student [id=122, name=Drek, gender=Male, rank=165]



//		Timestamping in Data JPA

Hibernate: select s1_0.student_id,s1_0.created_date,s1_0.student_gen,s1_0.student_name,s1_0.student_rank,s1_0.updated_date from student_dtls s1_0 where s1_0.student_id=?
Hibernate: insert into student_dtls (created_date,student_gen,student_name,student_rank,updated_date,student_id) values (?,?,?,?,?,?)
Record saved...


// soft and hard delete
Hibernate: select s1_0.student_id,s1_0.active_sw,s1_0.created_date,s1_0.student_gen,s1_0.student_name,s1_0.student_rank,s1_0.updated_date from student_dtls s1_0 where s1_0.student_id=?
Hibernate: insert into student_dtls (active_sw,created_date,student_gen,student_name,student_rank,student_id) values (?,?,?,?,?,?)
Record saved...


*/