package com.it.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.it.Question;
import com.it.dao.QuestionDao;
import com.it.dao.QuizDao;
import com.it.model.Quiz;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> allRandom=questionDao.findRandomQuestionByCategory(category);
		List<Question> limited = allRandom.stream().limit(5).collect(Collectors.toList());

		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(allRandom);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
}
