package com.edu.db.model.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.db.domain.Board;

//자동으로 메모리에 올림
@Repository
public class HibernateBoardDAO implements BoardDAO{

	@Override
	public List SelectAll() {
		return null;
	}

	@Override
	public Board select(int board_idx) {
		return null;
	}

	@Override
	public void insert(Board board) {
		
	}

	@Override
	public void update(Board board) {
		
	}

	@Override
	public void delete(int board_idx) {
		
	}
}
