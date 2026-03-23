package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Genre;

@Mapper
public interface GenreMapper {
	
	List<Genre> selectGenre();
	
	Genre selectGenreById(Integer id);
	
	void insert(Genre genre);
	
	void update(Genre genre);
	
	void delete(Integer id);

}
