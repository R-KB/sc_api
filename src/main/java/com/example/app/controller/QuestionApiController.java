package com.example.app.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.Question;
import com.example.app.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
public class QuestionApiController {
	
	private final QuestionService service;
	
	@GetMapping
	public ResponseEntity<List<Question>> getQuestion() {
		List<Question> questions = service.getAllQuestion();
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) {
		Question question = service.getQuestionById(id);
		HttpStatus status = question == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<>(question, status);
	}
	
	@GetMapping("/g/{genreId}")
	public ResponseEntity<List<Question>> getQuestionByGenre(@PathVariable Integer genreId) {
		List<Question> questions = service.getQuestionByGenre(genreId);
		HttpStatus status = questions == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<>(questions, status);
	}
	
	@PostMapping
	public ResponseEntity<Void> addQuestion(@RequestBody @Valid Question question, Errors errors) {
		if(errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.addQuestion(question);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping
	public ResponseEntity<Void> editQuestion(@RequestBody @Valid Question question, Errors errors) {
		if(errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.editQuestion(question);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id) {
		service.deleteQuestion(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
