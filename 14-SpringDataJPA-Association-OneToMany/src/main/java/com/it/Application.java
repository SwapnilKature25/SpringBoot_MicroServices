package com.it;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.entity.Address;
import com.it.entity.Employee;
import com.it.repository.AddressRepository;
import com.it.repository.EmpRepository;

@SpringBootApplication
public class Application {

    private final AddressRepository addressRepository;

    private final EmpRepository empRepository;

    Application(EmpRepository empRepository, AddressRepository addressRepository) {
        this.empRepository = empRepository;
        this.addressRepository = addressRepository;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmpRepository empRepository = context.getBean(EmpRepository.class);
		AddressRepository addressRepo = context.getBean(AddressRepository.class);
		
		 
//		1 - insert
		Employee e1=new Employee();
		e1.setEmpName("Eleven");
		e1.setEmpSalary(50000.0);
		
		Address a1=new Address();
		a1.setCity("Nagpur");
		a1.setState("MH");
		a1.setCountry("India");
		a1.setEmp(e1);

		Address a2=new Address();
		a2.setCity("Banglore");
		a2.setState("KA");
		a2.setCountry("India");
		a2.setEmp(e1);
		
		// setting addresses to employee
		List<Address> addrList = Arrays.asList(a1,a2);
		e1.setAddr(addrList);
		
//		empRepository.save(e1);
//		System.out.println("Record is inserted...");
		
//		if we don't use Casecade type as ALL for insertion operation then will not get error:
		
		
		
//		2  - delete
//		When i delete my current record child record will be deleted or not?
//		=> yes, because we are using Cascade as ALL.
//		Whatever the operation i do on the parent that operation should reflect on child also.
//		If we remove Cascade type then if we delete parent then only parent will be deleted child will not be deleted.
//		But when you delete the parent we want to delete the child also for that we are giving Cascade type as ALL.

//		empRepository.deleteById(3);
//		System.out.println("Record is deleted...");
		
		
//		if we don't use Casecade type as ALL for deletion operation then we get error : You are trying to persist 
//		or delete an entity (likely Address) that has a reference to another entity (Employee) that has not been saved to the database yet.
		
		
//		3  - retrieve/fetching
//		Here it will retrieve only parent record not child because fetch type is lazy loading.
//		When i retrieve the parent i want to retrieve the child also then we will use fetch type as EAGER.
//		The default fetch type is lazy if i fetch parent record then it will fetch only parent record. Now if we want to fetch parent + child record then we will go with fetch = FetchType.EAGER.
//		Cascade is applicable for non-select : insert , update and delete.
//		fetch is applicable for select : fetching
		empRepository.findById(3);
		System.out.println("Record found...");
			
//		if we don't use Casecade type as ALL for fetching operation then will not get error:
		
		
//		4  - retrieve by using child
//		When you retrieve the child record it will retrieve child record + parent record.
//		But when you retrieve the parent record it depends on fetch type.
		addressRepo.findById(3);
		System.out.println("Record found... (child + parent )");  // because parent reference will be available to child
//		if we don't use Casecade type as ALL for fetching operation then will not get error:

	}

}

/*
// 1 
Hibernate: drop table if exists address
Hibernate: drop table if exists employee
Hibernate: create table address (addr_id integer not null auto_increment, emp_id integer, city varchar(255), country varchar(255), state varchar(255), primary key (addr_id)) engine=InnoDB
Hibernate: create table employee (emp_id integer not null auto_increment, emp_salary float(53), emp_name varchar(255), primary key (emp_id)) engine=InnoDB
Hibernate: alter table address add constraint FKqle0sh55wsafol7dkqfqu1shc foreign key (emp_id) references employee (emp_id)
Hibernate: insert into employee (emp_name,emp_salary) values (?,?)
Hibernate: insert into address (city,country,emp_id,state) values (?,?,?,?)
Hibernate: insert into address (city,country,emp_id,state) values (?,?,?,?)
Record is inserted...


// 2
Hibernate: select e1_0.emp_id,e1_0.emp_name,e1_0.emp_salary from employee e1_0 where e1_0.emp_id=?
Hibernate: select a1_0.emp_id,a1_0.addr_id,a1_0.city,a1_0.country,a1_0.state from address a1_0 where a1_0.emp_id=?
Hibernate: delete from address where addr_id=?
Hibernate: delete from address where addr_id=?
Hibernate: delete from employee where emp_id=?
Record is deleted...

//3
// parent
Hibernate: select e1_0.emp_id,e1_0.emp_name,e1_0.emp_salary from employee e1_0 where e1_0.emp_id=?
Record is found...

parent + child
Hibernate: select e1_0.emp_id,e1_0.emp_name,e1_0.emp_salary,a1_0.emp_id,a1_0.addr_id,a1_0.city,a1_0.country,a1_0.state from employee e1_0 left join address a1_0 on e1_0.emp_id=a1_0.emp_id where e1_0.emp_id=?
Record found...


//4
Hibernate: select a1_0.addr_id,a1_0.city,a1_0.country,e1_0.emp_id,e1_0.emp_name,e1_0.emp_salary,a1_0.state from address a1_0 left join employee e1_0 on e1_0.emp_id=a1_0.emp_id where a1_0.addr_id=?
Hibernate: select a1_0.emp_id,a1_0.addr_id,a1_0.city,a1_0.country,a1_0.state from address a1_0 where a1_0.emp_id=?


*/
