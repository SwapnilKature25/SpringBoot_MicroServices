package com.it.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.model.Quiz;
										// type of table , type of primary key
public interface QuizDao extends JpaRepository<Quiz, Integer>
{

}
