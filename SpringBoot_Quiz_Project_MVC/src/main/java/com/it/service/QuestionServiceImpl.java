package com.it.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.it.dao.QuestionDao;
import com.it.model.Question;

public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionDao questionDao;
	
	@Override
	public List<Question> getAllQuestions() {
		return questionDao.findAll();
	}

	@Override
	public List<Question> getQuestionsByCategory() {
		return questionDao.findByCategory(null)
	}

	@Override
	public boolean addQuestion(Question question) {
		return false;
	}

	@Override
	public void deleteQuestion(Integer questionId) {
	}

	
}
