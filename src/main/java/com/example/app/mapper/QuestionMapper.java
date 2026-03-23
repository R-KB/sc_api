package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Question;

@Mapper
public interface QuestionMapper {
	
	List<Question> selectQuestion();
	
	Question selectQuestionById(Integer id);
	
	List<Question> selectQuestionByGenre(Integer genre_id);
	
	void insert(Question question);
	
	void update(Question question);
	
	void delete(Integer id);
	
	

}
