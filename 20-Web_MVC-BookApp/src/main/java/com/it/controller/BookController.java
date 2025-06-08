package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.it.entity.Book;
import com.it.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
//	@Autowired
//	private BookRepository bookRepo;
	
	@GetMapping("/books")
	public ModelAndView getBooks()
	{
		ModelAndView mav=new ModelAndView();
		List<Book> allBooks = service.getAllBooks();	
		mav.addObject("books", allBooks);
		mav.setViewName("book");  // Whenever we use setViewName then we need to create html file with same name
		return mav;		
	}
		
	/*    // 1
	@GetMapping("/index")   // used to display empty form
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
//		seding empty obj for  form binding
		mav.addObject("book", new Book());  // emty object data will not come ( it id comes it will treat it has a old record if not then it will create new record)
		mav.setViewName("index");
		return mav;
	}   */
	
	/*  // 2
	@GetMapping("/index")   // used to display empty form
	public String index(Model model) {
		model.addAttribute("book", new Book());  
		return "index";
	}  */

		// 3
	@GetMapping("/index")   // used to display empty form
	public String index(@ModelAttribute("book") Book book) {
		return "index";
	}
	
	@PostMapping("/book")
	public ModelAndView saveBooks(Book book) {
		ModelAndView mav=new ModelAndView();
//		System.out.println(book);
		boolean status = service.saveBook(book);
		if(status) {
			mav.addObject("succMsg","Book Saved");
		}else {
			mav.addObject("errMsg","Failed to Save");			
		}
		
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBooks(@RequestParam("bookId") Integer bookId) {
		ModelAndView mav=new ModelAndView();
		
		service.deleteBook(bookId);
		List<Book> allBooks = service.getAllBooks();	
		mav.addObject("books", allBooks);
		mav.setViewName("book");
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView editBook(@RequestParam("bookId")  Integer bookId) {   // bookId it will take from Query parameter. 
		Book bookObj = service.getBookById(bookId);   // will retrieve the data from DB 
		ModelAndView mav=new ModelAndView();
//		seding existing obj for form binding
		mav.addObject("book",bookObj);   // will send the record to UI by using Model
		mav.setViewName("index");  // in the index page data will be loaded
		return mav;
	}
	
}
