package com.edu.springboard.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	//목록 요청
	@GetMapping("/notice/list")
	public ModelAndView noticeMain() {
		
		return new ModelAndView("notice/list");
	}
	
	//글등록 폼 요청
	@GetMapping("/notice/registform")
	public ModelAndView registForm() {
		
		return new ModelAndView("notice/regist");
	}
	
	//상세 요청
	@GetMapping("/notice/detail")
	public ModelAndView getDetail(int notice_idx) {
		//여기서 3단계 업무 시켜서, 4단계도 가능하지만 수업 주제가 RESTfull 이기 때문에 js에서 상세요청 처리
		ModelAndView mav=new ModelAndView("notice/detail");
		mav.addObject("notice_idx", notice_idx);
		
		return mav;
	}
}
