package com.edu.mvc2.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.edu.mvc2.model.board.BoardService;

import lombok.Setter;

//게시판의 글삭제 요청을 처리할 하위 컨트롤러
//Spring 2.x 방식
@Setter
public class DeleteController implements Controller{
	private BoardService boardService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계) 일시키기
		String board_idx=request.getParameter("board_idx");
		boardService.delete(Integer.parseInt(board_idx));
		
		//4단계) 결과 저장 
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/board/list");
		
		return mav;
	}
}
