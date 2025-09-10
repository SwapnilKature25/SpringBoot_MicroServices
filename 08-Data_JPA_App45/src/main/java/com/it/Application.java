package com.it;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.entity.Employee;
import com.it.repo.EmpRepository;

@SpringBootApplication
public class Application {

    private final EmpRepository empRepository;

    Application(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
	
		EmpRepository repo = ctx.getBean(EmpRepository.class);
		// getBean() will get the object of bean but it is interface so IOC will provide implementation class of interface but we are not providing implementationc class so data jpa will provide impl class. 
		// As the EmpRepository is interface then here data jpa will provide implementation for the interface in runtime by using proxy class
		
		// to know which class object is stored into the repo variable
//		System.out.println(repo.getClass().getName());   // jdk.proxy2.$Proxy95
	
		Employee emp=new Employee();
		emp.setEmpId(1);
		emp.setEmpName("Ashok");
		emp.setEmpDesg("SD");
		emp.setEmpAddr("Hyd");
		
		Employee emp2=new Employee();
		emp2.setEmpId(2);
		emp2.setEmpName("Swapnil");
		emp2.setEmpDesg("SD");
		emp2.setEmpAddr("Pune");
//		repo.save(emp);      // upsert method -> single method will perform update + insert 
		
		List<Employee> empList = Arrays.asList(emp, emp2);
		repo.saveAll(empList);
		
		System.out.println("Record inserted");
		
		/*
		// fetching record
		Optional<Employee> findById = repo.findById(1);
		
		// Option 1: Using ifPresent()
		findById.ifPresent(empObj -> {
		    System.out.println("Employee Id   : " + empObj.getEmpId());
		    System.out.println("Employee Name : " + empObj.getEmpName());
		    System.out.println("Employee Desg : " + empObj.getEmpDesg());
		    System.out.println("Employee Addr : " + empObj.getEmpAddr());
		});

		System.out.println();
		// Option 2: Using orElseThrow()
		Employee empRecord = findById.orElseThrow(() -> new RuntimeException("Employee not found"));
		System.out.println(empRecord);

		System.out.println();
		// Option 3: Using orElse(null) – not recommended but works
		Employee empRecord2 = findById.orElse(null);
		if (empRecord2 != null) {
		    System.out.println(empRecord2);
		} else {
		    System.out.println("No record found");
		}
		*/
		
		Optional<Employee> findById = repo.findById(2);
		if(findById.isPresent()) { 
			System.out.println(findById.get());   // fetching object
		}
		
		Iterable<Employee> findAll = repo.findAll();
		findAll.forEach(System.out::println);
		
	}

}
