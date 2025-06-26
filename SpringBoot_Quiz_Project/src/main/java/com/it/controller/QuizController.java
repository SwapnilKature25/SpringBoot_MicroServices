package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.QuestionWrapper;
import com.it.model.Responses;
import com.it.service.QuestionService;
import com.it.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuestionService questionService; 
	
	@Autowired
	QuizService quizService;

    QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }
	
//  POST :  localhost:8080/quiz/create?category=java&numQ=5&title=JQuiz
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam("category") String category, @RequestParam("numQ") int numQ, @RequestParam("title") String title){	
		return quizService.createQuiz(category, numQ, title);	
	}
	
//	GET : localhost:8080/quiz/get/1
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") Integer id){
		return quizService.getQuestions(id);
	}
	
//	localhost:8080/quiz/submit/1
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable("id") Integer id, @RequestBody List<Responses> responses){
		return quizService.calculateResult(id,responses);
	}
	
	
	
	/*
	 [
    {
        "cid": 10,
        "response": "Ability to take multiple forms"
    },
    {
        "cid": 21,
        "response": "Java Virtual Machine"
    },
    {
        "cid": 28,
        "response": "Both option1 anf option2"
    },
    {
        "cid": 2,
        "response": "Object-Oriented Programming"
    },
    {
        "cid": 19,
        "response": "A linear data structure"
    }
 ]
	
	*/
	
}
