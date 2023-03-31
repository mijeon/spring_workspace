package com.edu.mvc2.model.board;

import java.util.List;

import com.edu.mvc2.domain.Board;

/*
 	곧 이 DAO 객체를 서비스가 사용할 예정이므로, service 입장에선  dao와의 결합도를 낮춰야한다.
	board dao의 최상위 객체를 정의한다
*/
public interface BoardDAO {
	public List selectAll();  //모두 가져오기
	public Board select(int board_idx);  //한건 가져오기
	public void insert(Board board);  //등록
	public void update(Board board);  //수정
	public void delete(int board_idx);  //삭제
}
