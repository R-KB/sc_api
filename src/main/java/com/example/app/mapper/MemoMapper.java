package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Memo;

@Mapper
public interface MemoMapper {
	
	List<Memo> selectMemo();
	
	Memo selectMemoById(Integer id);
	
	List<Memo> selectMemoByQuestion(Integer q_id);
	
	void insert(Memo memo);
	
	void update(Memo memo);
	
	void delete(Integer id);

}
