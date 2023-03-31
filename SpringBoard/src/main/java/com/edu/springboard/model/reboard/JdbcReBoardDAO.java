package com.edu.springboard.model.reboard;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.ReBoard;

@Repository
public class JdbcReBoardDAO implements ReBoardDAO{

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public ReBoard select(int reboard_idx) {
		return null;
	}

	@Override
	public void insert(ReBoard reboard) {
		
	}

	@Override
	public void update(ReBoard reboard) {
		
	}

	@Override
	public void delete(int reboard_idx) {
		
	}

	@Override
	public void updateStep(ReBoard reboard) {
		
	}

	@Override
	public void reply(ReBoard reboard) {
		
	}
}
