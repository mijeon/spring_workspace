package com.edu.springshop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.domain.Admin;
import com.edu.springshop.exception.AdminException;
import com.edu.springshop.model.admin.AdminService;

@Controller
public class AdminController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminService adminService;
	
	//관리자 로그인폼 요청처리
	@GetMapping("/loginform")
	public ModelAndView getLoginForm(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("admin/login/loginform");
		
		return mav;
	}
	
	//동기 로그인 요청처리
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request, Admin admin) {
		//3단계) 일 시키기
		adminService.select(admin);
		
		ModelAndView mav=new ModelAndView("redirect:/admin/main");
		return mav;
	}
	
	//관리자 메인 요청처리
	@GetMapping("/main")
	public ModelAndView getMain(HttpServletRequest request ) { // int x 배열로 넘어오는걸 확인하기 위함
		logger.info("관리자 메인 호출됨");
		
		//이 시점에 로그인 인증여부를 따져봐야 함
		HttpSession session=request.getSession();
		Admin admin=(Admin)session.getAttribute("admin");

		ModelAndView mav=new ModelAndView();
		
		if(admin==null) {
			throw new AdminException("로그인이 필요한 서비스입니다.");
		}else {
			mav.setViewName("admin/index");  //정상 링크
		}
		return mav;
	}
}
