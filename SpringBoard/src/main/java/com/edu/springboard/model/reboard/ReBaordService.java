package com.edu.springboard.model.reboard;

import java.util.List;

import com.edu.springboard.domain.ReBoard;

public interface ReBaordService {
	//dao와 service는 메서드명이 같아야 한다는 기준은 없지만 업무내용이 동일하므로 굳이 다르게 줄 이유가 없음
	public List selectAll();
	public ReBoard select(int reboard_idx);
	public void insert(ReBoard reboard);
	public void update(ReBoard reboard);
	public void delete(int reboard_idx);
	
	//답변관련
	public void registReply(ReBoard reboard);  //답변등록 (updateStep + reply)
}
