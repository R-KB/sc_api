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

import com.example.app.domain.Memo;
import com.example.app.service.MemoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/memo")
public class MemoApiController {
	
	private final MemoService service;
	
	@GetMapping
	public ResponseEntity<List<Memo>> getMemo() {
		List<Memo> memos = service.getAllMemo();
		return new ResponseEntity<>(memos,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Memo> getMemoById(@PathVariable Integer id) {
		Memo memo = service.getMemoById(id);
		HttpStatus status = memo == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<>(memo, status);
	}
	
	@GetMapping("/q/{qId}")
	public ResponseEntity<List<Memo>> getMemoByQuestion(@PathVariable Integer qId) {
		List<Memo> memos = service.getMemoByQuestion(qId);
		HttpStatus status = memos == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<>(memos, status);
	}
	
	@PostMapping
	public ResponseEntity<Void> addMemo(@RequestBody @Valid Memo memo, Errors errors) {
		if(errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.addMemo(memo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@PutMapping
	public ResponseEntity<Void> editMemo(@RequestBody @Valid Memo memo, Errors errors) {
		if(errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		service.editMemo(memo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMemo(@PathVariable Integer id) {
		service.deleteMemo(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
