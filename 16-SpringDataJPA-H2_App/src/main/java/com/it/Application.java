package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.entity.Employee;
import com.it.repository.EmpRepository;

@SpringBootApplication
public class Application {

    private final EmpRepository empRepository;

    Application(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmpRepository empRepository = context.getBean(EmpRepository.class);
		Employee emp=new Employee();
		emp.setEname("Raju");
		emp.setEsal(10000.0);
		
		Employee save = empRepository.save(emp);    // it will be going to store record in H2 database
		System.out.println("Record saved");
		System.out.println(save);
	}

}

/*

Hibernate: create global temporary table HTE_employee(emp_id integer, rn_ integer not null, esal float(53), ename varchar(255), primary key (rn_)) TRANSACTIONAL
[2m2025-05-29T00:53:27.307+05:30[0;39m [32m INFO[0;39m [35m18364[0;39m [2m--- [16-SpringDataJPA-H2_App] [           main] [0;39m[36mo.h.e.t.j.p.i.JtaPlatformInitiator      [0;39m [2m:[0;39m HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
Hibernate: drop table if exists employee cascade 
Hibernate: drop sequence if exists employee_seq
Hibernate: create sequence employee_seq start with 1 increment by 50
Hibernate: create table employee (emp_id integer not null, esal float(53), ename varchar(255), primary key (emp_id))
Hibernate: select next value for employee_seq
Hibernate: insert into employee (ename,esal,emp_id) values (?,?,?)
Record saved
Employee [empId=1, ename=Raju, esal=10000.0]



*/
