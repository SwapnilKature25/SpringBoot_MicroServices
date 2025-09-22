package com.it;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		App a = new App();
//		a.convertJavaToJson();
		a.convertJsonToJava();
	}

	public void convertJsonToJava() throws StreamReadException, DatabindException, IOException {
		File f=new File("customer.json");
		
		ObjectMapper mapper=new ObjectMapper();
		Customer customer = mapper.readValue(f, Customer.class);
		System.out.println(customer);
	}

	public void convertJavaToJson() throws StreamWriteException, DatabindException, IOException {
		Customer c = new Customer();
		c.setId(111);
		c.setName("Ashok");
		c.setPhno(8767567654l);
		c.setGender("Male");

		File f = new File("customer.json");
		ObjectMapper mapper = new ObjectMapper();

		// serialization
		mapper.writeValue(f, c);

		System.out.println("Serialization completed...");
	}
}
