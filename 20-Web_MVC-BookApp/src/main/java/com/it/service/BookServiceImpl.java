package com.it.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.controller.BookController;
import com.it.entity.Book;
import com.it.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> getAllBooks() {
//		we can get active Books in multiple ways like 1. findByXXX() ,2.CustomQuery , 3.QueryByExample
//		return bookRepo.findAll();
		return bookRepo.findByActiveSW("Y");
	}

	@Override
	public boolean saveBook(Book book) {
		book.setActiveSW("Y");
		
		Book savedBook = bookRepo.save(book);
		/*
		if(savedBook.getBookId()!=null) {
			return true;
		}
		return false;
		*/
		return savedBook.getBookId()!= null;
	}

	@Override
	public void deleteBook(Integer bookId) {
		// hard delete
		//		bookRepo.deleteById(bookId);
		
		// soft delete
		Optional<Book> findById = bookRepo.findById(bookId);
		if(findById.isPresent()) {
			Book book = findById.get();
			book.setActiveSW("N");
			bookRepo.save(book);
		}
		
	}

	@Override
	public Book getBookById(Integer bookId) {
		Optional<Book> findById = bookRepo.findById(bookId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
}
