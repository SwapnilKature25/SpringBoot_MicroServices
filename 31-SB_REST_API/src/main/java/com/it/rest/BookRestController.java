package com.it.rest;

 
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.binding.Book;

@RestController
public class BookRestController {
	
	@PostMapping( value="/add",
				  consumes = {"application/xml","application/json"},
			        produces = MediaType.TEXT_PLAIN_VALUE)
	public String addBook(@RequestBody Book b) {
		System.out.println(b);
//		logic to save in DB
		return "Book Added";
	}
	
    @GetMapping(value = "/book",
    		    produces = {"application/xml", "application/json"})
	public Book getBook() {
		Book book=new Book(101, "Java", 524.90);
		return book;
	}
}