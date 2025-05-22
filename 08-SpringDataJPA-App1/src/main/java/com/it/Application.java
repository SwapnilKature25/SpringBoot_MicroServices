package com.it;

import java.util.Arrays;
import java.util.List;

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
		
		/* 
			saveAll()
		Student s1=new Student(103, "Allen", "Male", 111l);
		Student s2=new Student(104, "Jane", "Female", 11l);
		Student s3=new Student(105, "Mike", "Male", 112l);
		Student s4=new Student(106, "Max", "Female", 113l);
		
		List<Student> students = Arrays.asList(s1,s2,s3,s4);
		
		studentRepository.saveAll(students);  // all the students are accepting in the table at a time 
		*/
		
		
//		List<Student> maleStudents = studentRepository.findByGender("Male");
//		maleStudents.forEach(System.out::println);
		
//		List<Student> studentss = studentRepository.findByRankGreaterThanEqual(100);
//		studentss.forEach(System.out::println);
		
//		List<Student> studs = studentRepository.findByRankLessThanEqual(100);
//		studs.forEach(System.out::println);
		
		List<Student> stds = studentRepository.findByGenderAndRankGreaterThanEqual("Male", 100l);
		stds.forEach(System.out::println);
		
		
		
		
		/*  -->
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
		System.out.println("Records Count : "+count);  <-- */		
		
		
		
		
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
		 
		6] saveAll()
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_id=?
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_id=?
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_id=?
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_id=?
		
		
		7] findByXXX()  
		findByGender()
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_gen=?
		Student [id=103, name=Allen, gender=Male, rank=111]
		Student [id=105, name=Mike, gender=Male, rank=112]
		Student [id=112, name=Raja, gender=Male, rank=12]
		 
		8] findByRankGreaterThanEqual(100l)
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_rank>=?
		Student [id=103, name=Allen, gender=Male, rank=111]
		Student [id=105, name=Mike, gender=Male, rank=112]
		Student [id=106, name=Max, gender=Female, rank=113]
		
		9] findByRankLessThanEqual(100l)
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_rank<=?
		Student [id=104, name=Jane, gender=Female, rank=11]
		Student [id=112, name=Raja, gender=Male, rank=12]
		 
		 
		10] findByGenderAndRankGreaterThanEqual("Male", 100l)
		Hibernate: select s1_0.student_id,s1_0.student_gen,s1_0.student_name,s1_0.student_rank from student_dtls s1_0 where s1_0.student_gen=? and s1_0.student_rank>=?
		Student [id=103, name=Allen, gender=Male, rank=111]
		Student [id=105, name=Mike, gender=Male, rank=112]
		 
		 **/
	}

}
