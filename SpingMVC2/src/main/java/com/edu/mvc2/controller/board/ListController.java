package com.edu.mvc2.controller.board;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.edu.mvc2.model.board.BoardService;

import lombok.Setter;

//게시판의 목록 요청을 처리할 하위 컨트롤러
//Spring 2.x 방식
//주입을 위한 setter 추가
@Setter
public class ListController implements Controller{
	Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	private BoardService boardService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("게시판 목록 처리");
		
		//3단계) 일시키기
		List boardList=boardService.selectAll();
		
		//4단계) 결과 저장 원래는 request에 저장해야 하지만 ModelAndView에 저장하면
		//request에 자동으로 저장하도록 처리되어 있음
		
		//변경가능성이 있는 데이터에 대해선 new 하지 않음
		ModelAndView mav=new ModelAndView();
		mav.addObject("boardList", boardList);
		//mav.setViewName("/WEB-INF/views/    board/list    .jsp");  //(jsp key 값)
		mav.setViewName("board/list");  //forwarding
		
		return mav;
	}
}
