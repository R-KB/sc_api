package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Question {
	
	private Integer id;
	
	private Integer genreId;
	
	private String img;
	
	private String description;
	
	private String answer;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;

}
