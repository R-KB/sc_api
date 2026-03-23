package com.example.app.service;

import java.util.List;

import com.example.app.domain.Genre;

public interface GenreService {
	
	List<Genre> getAllGenre();
	
	Genre getGenreById(Integer id);
	
	void addGenre(Genre genre);
	
	void editGenre(Genre genre);
	
	void deleteGenre(Integer id);

}
