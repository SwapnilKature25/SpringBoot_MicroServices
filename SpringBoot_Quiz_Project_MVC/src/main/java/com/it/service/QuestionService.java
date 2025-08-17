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
public interface QuestionService {

	public List<Question> getAllQuestions();
	public List<Question> getQuestionsByCategory();
	public boolean addQuestion(Question question);
	public void deleteQuestion(Integer questionId);
}	
