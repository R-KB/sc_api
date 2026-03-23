package com.example.app.service;

import java.util.List;

import com.example.app.domain.Memo;

public interface MemoService {
	
	List<Memo> getAllMemo();
	
	Memo getMemoById(Integer id);
	
	List<Memo> getMemoByQuestion(Integer qId);
	
	void addMemo(Memo memo);
	
	void editMemo(Memo memo);
	
	void deleteMemo(Integer id);

}
