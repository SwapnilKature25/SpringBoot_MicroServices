package com.it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.it.SpringBootQuizApplication;
import com.it.dao.QuestionDao;
import com.it.dao.QuizDao;
import com.it.model.Question;
import com.it.model.QuestionWrapper;
import com.it.model.Quiz;
import com.it.model.Responses;

@Service
public class QuizService {

    private final SpringBootQuizApplication springBootQuizApplication;
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

    QuizService(SpringBootQuizApplication springBootQuizApplication) {
        this.springBootQuizApplication = springBootQuizApplication;
    }

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> allRandom=questionDao.findRandomQuestionByCategory(category);
		List<Question> limited = allRandom.stream().limit(5).collect(Collectors.toList());

		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(limited);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		// when we use optional first we have to get Object
		List<Question> questionsFromDB = quiz.get().getQuestions();
		
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		for(Question q : questionsFromDB)
		{
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getCategory() , q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Responses> responses) {
		Quiz quiz=quizDao.findById(id).get();
		List<Question> questions=quiz.getQuestions();
		int right=0;
		int i=0;
		for(Responses response : responses)
		{
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
} 
