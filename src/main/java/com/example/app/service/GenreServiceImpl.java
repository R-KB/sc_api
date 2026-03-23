package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Genre;
import com.example.app.mapper.GenreMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
	private final GenreMapper mapper;
	
	@Override
	public List<Genre> getAllGenre() {
		return mapper.selectGenre();
	}
	
	@Override
	public Genre getGenreById(Integer id) {
		return mapper.selectGenreById(id);
	}
	
	@Override
	public void addGenre(Genre genre) {
		mapper.insert(genre);
	}
	
	@Override
	public void editGenre(Genre genre) {
		mapper.update(genre);
	}
	
	@Override
	public void deleteGenre(Integer id) {
		mapper.delete(id);
	}
	
	

}
