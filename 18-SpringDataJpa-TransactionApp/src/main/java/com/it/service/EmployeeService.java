package com.it.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.it.Application;
import com.it.entity.Address;
import com.it.entity.Emp;
import com.it.repo.AddressRepo;
import com.it.repo.EmpRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

    private final Application application;

	private EmpRepo empRepo;
	private AddressRepo addRepo;
//	Autowiring is Optional because there is only one constructor IOC container will 
//	call the same constructor to create the Object for our target class
	public EmployeeService(EmpRepo empRepo, AddressRepo addRepo, Application application) {
		super();
		this.empRepo = empRepo;
		this.addRepo = addRepo;
		this.application = application;
	}
	
	// whatever the operations happen in the method should acts as a single transaction ( to achieve Atomicity )
//	Hey JPA whenever exception occurs in the method you rollback all the transaction, u should not insert emp data if addr insertion failed
	@Transactional(rollbackOn = Exception.class)         // here jpa is thinking emp.save and addr.save both are 2 diff transactions so to tell jpa that both refers to 1 trans we use @Transactional annotation.	
	public void saveData()
	{
//		To represent that these 2 operations belongs to 1 transaction we are using @Transactional annotation
		Emp emp=new Emp();
		emp.setEmpName("Naresh");
		emp.setEmpSal(65000.0);
		
		Emp savedEntity = empRepo.save(emp);   
		// after inserting the entity primary key value will be available
		
//		int i=10/0;   // here it is not following Atomicity because as exception occurs it is not allowing addr but it is allowing employee data which is why it is failed
		
		Address addr=new Address();
		addr.setCity("Banglore");
		addr.setState("KA");
		addr.setCountry("IN");
		addr.setType("Permanent");
		
		Address addr2=new Address();
		addr2.setCity("Pune");
		addr2.setState("MH");
		addr2.setCountry("IN");
		addr2.setType("Permanent");
		
		addr.setEmpId(savedEntity.getEmpId());
		addr2.setEmpId(savedEntity.getEmpId());
		
		List<Address> addresses = Arrays.asList(addr,addr2);
//		addRepo.save(addr);   // for saving single address
		addRepo.saveAll(addresses);
		
	}
	
	// deleting both emp and address
	@Transactional
	public void deleteEmployeeAndAddresses(Integer empId) {
	    addRepo.deleteByEmpId(empId);  // Delete all addresses of the employee
	    empRepo.deleteById(empId);     // Then delete employee
	}

}
