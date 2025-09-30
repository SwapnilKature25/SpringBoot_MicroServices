package com.it.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.entity.Book;

@RestController
public class BookRestController {
	
	@GetMapping(value="/book", produces = "application/json")
	 public ResponseEntity<Book> getBook(){
		 Book b=new Book(101,"Java",1000l);
		 //							response body, status code
		 return new ResponseEntity<>(b,HttpStatus.OK);
	 }

	@GetMapping(value="/books", produces="application/json")
	public ResponseEntity<List<Book>> getAllBooks(){
		Book b1=new Book(101,"Java",1000l);
		Book b2=new Book(104,"Python",1000l);
		Book b3=new Book(103,"C++",1000l);
		
		List<Book> books = Arrays.asList(b1,b2,b3);
		//							response body, status code
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
}
