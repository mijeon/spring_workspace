package com.edu.springmvc1.model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.edu.springmvc1.domain.Board;
import com.edu.springmvc1.exception.BoardException;



public class BoardDAO {
	private SqlSession sqlSession;  
	
	//트랜잭션 주입받기 위한 setter 준비
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//모두 가져오기
	public List selectAll() {
		return sqlSession.selectList("Board.selectAll");
	}	
	
	//한건 가져오기
	public Board select(int board_idx) {
		return sqlSession.selectOne("Board.select", board_idx);
	}
	
	//등록
	public void insert(Board board) throws BoardException{
		int result=sqlSession.insert("Board.insert", board);
		if(result<1) {
			throw new BoardException("등록실패");
		}
	}
	
	//수정
	public void update(Board board) throws BoardException {
		int result=sqlSession.update("Board.update", board);
		if(result<1) {
			throw new BoardException("수정실패");
		}
	}
	
	//삭제
	public void delete(int board_idx) throws BoardException {
		int result=sqlSession.update("Board.delete", board_idx);
		if(result<1) {
			throw new BoardException("삭제실패");
		}
	}
	
}
