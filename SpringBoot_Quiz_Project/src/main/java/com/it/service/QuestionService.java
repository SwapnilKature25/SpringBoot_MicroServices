package com.it.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.it.dao.QuestionDao;
import com.it.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	// to handle exception use ResponseEntity as return type
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity(questionDao.findAll(),HttpStatus.OK);	  // here we are returning data and status code	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);			
		
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity(questionDao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);			
	}

	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("Success...",HttpStatus.CREATED);
	}

	public ResponseEntity<String> deleteQuestion(Question question) {
		questionDao.delete(question);
		return new ResponseEntity<>("Deleted...",HttpStatus.CREATED);
	} 
	
}	
