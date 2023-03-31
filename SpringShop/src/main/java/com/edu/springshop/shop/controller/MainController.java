package com.edu.springshop.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.model.product.ProductService;

//쇼핑몰의 메인을 처리하는 하위 컨트롤러 - 동기
@Controller
public class MainController {
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/")
	public ModelAndView getMain(HttpServletRequest request) {
		//3단계) 일시키기
		List categoryList=categoryService.selectAll();
		
		//4단계) 저장할 것이 있으면 결과 저장 (왜? jsp로 가져가야 하므로)
		ModelAndView mav=new ModelAndView();
		mav.addObject("categoryList", categoryList);
		
		mav.setViewName("shop/index");
		
		return mav;
	}
	
	//상담게시판 페이지 요청처리
	@GetMapping("/member/chatform")
	public ModelAndView getChatForm(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("shop/member/chat");
		
		return mav;
	}
}
