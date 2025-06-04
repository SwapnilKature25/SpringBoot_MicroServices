package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>
{
	public List<Book> findByActiveSW(String status);
}
