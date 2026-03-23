package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Question;
import com.example.app.mapper.QuestionMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
	
	private final QuestionMapper mapper;
	
	@Override
	public List<Question> getAllQuestion() {
		return mapper.selectQuestion();
	}
	
	@Override
	public Question getQuestionById(Integer Id) {
		return mapper.selectQuestionById(Id);
	}
	
	@Override
	public List<Question> getQuestionByGenre(Integer genreId) {
		return mapper.selectQuestionByGenre(genreId);
	}
	
	@Override
	public void addQuestion(Question question) {
		mapper.insert(question);
	}
	
	@Override
	public void editQuestion(Question question) {
		mapper.update(question);
	}
	
	@Override
	public void deleteQuestion(Integer id) {
		mapper.delete(id);
	}

}
