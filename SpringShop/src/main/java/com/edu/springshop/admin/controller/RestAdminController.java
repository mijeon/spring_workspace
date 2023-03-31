package com.edu.springshop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Admin;
import com.edu.springshop.exception.AdminException;
import com.edu.springshop.model.admin.AdminService;
import com.edu.springshop.util.Message;

//비동기
@RestController
@RequestMapping("/rest")
public class RestAdminController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminService adminService;
	
	//로그인 요청 처리
	@PostMapping("/login/admin")
	public ResponseEntity<Message> loginCheck(Admin admin, HttpServletRequest request){
		logger.info("admin is " + admin);
		
		//3단계) 일시키기
		Admin obj=adminService.select(admin);
		
		//세션에 담기
		HttpSession session=request.getSession();
		session.setAttribute("admin", obj);
		
		//4단계)
		Message message=new Message();
		message.setMsg("로그인 성공");
		ResponseEntity<Message> entity=new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	/*
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<Message> hanble(AdminException e){
		Message message=new Message();
		message.setMsg(e.getMessage());
		ResponseEntity<Message> entity=new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	*/
}
