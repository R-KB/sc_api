package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Genre {
	
	private Integer id;
	
	private String name;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;

}
