package com.example.app.service;

import java.util.List;

import com.example.app.domain.Question;

public interface QuestionService {
	
	List<Question> getAllQuestion();
	
	Question getQuestionById(Integer id);
	
	List<Question> getQuestionByGenre(Integer genreId);
	
	void addQuestion(Question question);
	
	void editQuestion(Question question);
	
	void deleteQuestion(Integer id);

}
