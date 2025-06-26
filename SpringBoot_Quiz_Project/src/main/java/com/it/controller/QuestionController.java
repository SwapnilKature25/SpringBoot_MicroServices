package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.Question;
import com.it.service.QuestionService;

// HTTP response status codes  : https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
//	localhost:8080/question/allQuestions
	// to handle exception
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();   
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionCategory(@PathVariable("category") String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
//	localhost:8080/question/delete
	@DeleteMapping("delete")
	public ResponseEntity<String> deleteQuestion(@RequestBody Question question) {
		return questionService.deleteQuestion(question);
	}
}
