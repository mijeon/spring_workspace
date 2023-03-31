package com.edu.springshop.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.domain.Category;

@Controller
public class CategoryController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	//카테고리 관리 메인 요청
	@GetMapping("/category/main")
	public ModelAndView getMain(HttpServletRequest request) {
		
		return new ModelAndView("/admin/category/category_main");
	}
	
	//수정요청 처리 (동기 확인)
	//PostMappint("/category/edit") //post 확인	
	@PutMapping("/category/edit")  
	public ModelAndView edit(Category category) {
		logger.info("넘어온 category=" +category );
		
		return null;
	}
}
