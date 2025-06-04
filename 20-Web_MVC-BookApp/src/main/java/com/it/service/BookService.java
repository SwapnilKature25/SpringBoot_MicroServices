package com.it.service;

import java.util.List;

import com.it.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	
	public boolean saveBook(Book book);
	
	public void deleteBook(Integer bookId);

	public Book getBookById(Integer bookId);
}
