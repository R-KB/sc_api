package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Memo {
	
	private Integer id;
	
	private Integer qId;
	
	private String memo;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;

}
