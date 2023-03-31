package com.edu.db.model.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.db.domain.Board;
import com.edu.db.exception.BoardException;

//아래의 어노테이션은 무조건 명시하는게 아니라 빈 설정파일의 양을 줄이고자 xml에 빈등록을 하지 않았을 경우 사용되는 방법
//즉, component-scan을 이용하고자 할 경우 사용함
@Repository
public class MybatisBoardDAO implements BoardDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List SelectAll() {
		return sqlSessionTemplate.selectList("Board.selectAll");
	}

	@Override
	public Board select(int board_idx) {
		return sqlSessionTemplate.selectOne("Board.select", board_idx);
	}

	@Override
	public void insert(Board board) throws BoardException{
		int result=0;
		result=sqlSessionTemplate.insert("Board.insert", board);
		if(result<1) {
			throw new BoardException("등록 실패");
		}
	}

	@Override
	public void update(Board board) throws BoardException{
		int result=0;
		result=sqlSessionTemplate.update("Board.update", board);
		if(result<1) {
			throw new BoardException("수정 실패");
		}
	}

	@Override
	public void delete(int board_idx) throws BoardException{
		int result=0;
		result=sqlSessionTemplate.delete("Board.delete", board_idx);
		if(result<1) {
			throw new BoardException("삭제 실패");
		}
	}
}
