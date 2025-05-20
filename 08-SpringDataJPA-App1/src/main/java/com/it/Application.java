package com.it;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
//		System.out.println(studentRepository.getClass().getName());    // jdk.proxy2.$Proxy97
		
		Student s=new Student();
		s.setId(112);
		s.setName("Raja");
		s.setGender("Male");
		s.setRank(12l);
		
//		studentRepository.save(s);   // to insert or update record in db table
//		System.out.println("Record inserted...");

		Optional<Student> opt = studentRepository.findById(111);	// to search or retrieve by id 
		if(opt.isPresent()) {
			System.out.println(opt.get());    // Student [id=111, name=Raja, gender=1234, rank=1231]
		}
		else {
			System.out.println("Record not found...");
		}
			
		System.out.println("  -------------------   ");
		
		Iterable<Student> findAll = studentRepository.findAll();  // used to retrieve all the records from the table
		findAll.forEach(System.out::println);
		
		System.out.println("  -------------------   ");
		
		if(studentRepository.existsById(111)) {   // to check if record is available or not
			studentRepository.deleteById(111);
			System.out.println("Record deleted.....");			
		}
		else {
			System.out.println("Record not available.....");						
		}
			
		// existById() will check the record 
		// findById() will retrieve the record and give the record
		
		
		System.out.println("  -------------------   ");
		
		long count = studentRepository.count();
		System.out.println("Records Count : "+count);		
		/* 
		1]  save()
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_id=?
		Hibernate: update student_dtls set student_gen=?,student_name=?,student_rank=? where student_id=?
		Record inserted... 
		 
		2] findById()
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_id=?
		Student [id=111, name=Raja, gender=1234, rank=1231]

		3] findAll()    
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0
		Student [id=111, name=Raja, gender=1234, rank=1231]
		Student [id=112, name=Raja, gender=Male, rank=12] 
		
		4] deleteById()
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_id=?
		Record deleted.....
		
		using existById() 
		Hibernate: select count(*) from student_dtls s1_0 where s1_0.student_id=?
		Record not available.....
		
		5] count()
		Hibernate: select count(*) from student_dtls s1_0
		Records Count : 1
		 **/
	}

}
