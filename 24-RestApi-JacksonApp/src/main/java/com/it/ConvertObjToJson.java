package com.it;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertObjToJson {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		Customer c=new Customer(101,"John","john@gmail.com");
		
		// convert obj to json format
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(new File("Customer.json"), c);
		System.out.println("Completed....");
	}
}
