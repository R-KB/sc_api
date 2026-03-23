package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Memo;
import com.example.app.mapper.MemoMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {
	
	private final MemoMapper mapper;
	
	@Override
	public List<Memo> getAllMemo() {
		return mapper.selectMemo();
	}
	
	@Override
	public Memo getMemoById(Integer id) {
		return mapper.selectMemoById(id);
	}
	
	@Override
	public List<Memo> getMemoByQuestion(Integer qId) {
		return mapper.selectMemoByQuestion(qId);
	}
	
	@Override
	public void addMemo(Memo memo) {
		mapper.insert(memo);
	}
	
	@Override
	public void editMemo(Memo memo) {
		mapper.update(memo);
	}
	
	@Override
	public void deleteMemo(Integer id) {
		mapper.delete(id);
	}

}
