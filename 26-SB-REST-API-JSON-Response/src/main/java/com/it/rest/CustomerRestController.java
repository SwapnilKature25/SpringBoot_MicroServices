package com.it.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.binding.Customer;

@RestController
public class CustomerRestController {
	
//	value represents url pattern of the method , produces="application/json" -> it is optional and when we see this method we can understand that it will produce output in the Json format. 
	@GetMapping(value="/customer", produces="application/json") // mapping this method to GET request
	public ResponseEntity<Customer> getCustomer(){
//		In future we will get it from DB
		Customer c=new Customer(1,"John","john@gmail.com");
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/customers", produces="application/json")
	public List<Customer> getCustomers(){
		Customer c1=new Customer(1,"John","john@gmail.com");
		Customer c2=new Customer(3,"Smith","sm@gmail.com");
		Customer c3=new Customer(2,"trump","tr@gmail.com");

		List<Customer> customers = Arrays.asList(c1,c2,c3);
		return customers;
	}
	
//	produces will tell in which format this method will provide the response to the consumers.
//	consumes will represent in which format this method will take the input.
//	it is producing plain text and this method is consuming json 
//	method input will be represented by consumes and output by produces
	@PostMapping(value="/customer", produces="text/plain", consumes="application/json" )
	public String addCustomer(@RequestBody Customer c) {    // input is json output is string 
		System.out.println(c);
//		TODO : DB login in future
		return "Customer addedd";
	}
	
	@PutMapping(value="/customer", consumes="application/json", produces="text/plain")
	public String updateCustomer(@RequestBody Customer c) {
		System.out.println(c);
		return "Customer updated";
	}
	
//	it is not consuming anything from body only it is taking through path variable or through direct url  
	@DeleteMapping(value="/customer/{cid}", produces="text/plain")
	public String deleteCustomer(@PathVariable Integer cid) {
		// db logic to delete
		return "Customer deleted";
	}
	
}
