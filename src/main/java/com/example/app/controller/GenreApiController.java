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

import com.example.app.domain.Genre;
import com.example.app.service.GenreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genre")
public class GenreApiController {
	
	private final GenreService service;
	
	@GetMapping
	public ResponseEntity<List<Genre>> getGenre() {
		List<Genre> genres = service.getAllGenre();
		return new ResponseEntity<> (genres,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genre> getGenreById(@PathVariable Integer id) {
		Genre genre = service.getGenreById(id);
		HttpStatus status = genre == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<>(genre, status);
	}
	
	@PostMapping
	public ResponseEntity<Void> addGenre(@RequestBody @Valid Genre genre, Errors errors) {
		if(errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.addGenre(genre);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping
	public ResponseEntity<Void> editGenre(@RequestBody @Valid Genre genre, Errors errors) {
		if(errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.editGenre(genre);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGenre(@PathVariable Integer id) {
		service.deleteGenre(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
