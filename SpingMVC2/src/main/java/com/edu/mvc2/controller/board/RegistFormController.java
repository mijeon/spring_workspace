package com.edu.mvc2.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//보안된 WEB-INF 폴더에 들어있기 때문에 컨트롤러로 접근가능함
//게시판의 글등록폼 요청을 처리할 하위 컨트롤러
//Spring 2.x 방식
public class RegistFormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//게시판 등록폼의 이름 등록
		ModelAndView mav=new ModelAndView();
		mav.setViewName("board/regist");
		
		return mav;
	}
}
