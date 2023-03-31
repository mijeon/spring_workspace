package com.edu.springboard.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.exception.FileUploadException;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.model.gallery.GalleryService;

//갤러리와 관련된 모든 요청을 처리하는 하위 컨트롤러 (.jsp)
@Controller
public class GalleryController {
	Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	//느슨하게 보유
	@Autowired
	private GalleryService galleryService;
	
	//등록폼 요청
	@GetMapping("/gallery/registform")
	public ModelAndView registForm() {
		
		return new ModelAndView("/gallery/regist");
	}
	
	//컨트롤러 메서드들에서 예외가 발생했을 경우 처리
	@ExceptionHandler(FileUploadException.class)
	public ModelAndView handle(FileUploadException e) {
		ModelAndView mav=new ModelAndView("/err/result");
		mav.addObject("e", e);  //포워딩
		
		return mav;
	}
	
	@ExceptionHandler(GalleryException.class)
	public ModelAndView handle(GalleryException e) {
		ModelAndView mav=new ModelAndView("/err/result");
		mav.addObject("e", e);  //포워딩
		
		return mav;
	}
	
	@ExceptionHandler(PhotoException.class)
	public ModelAndView handle(PhotoException e) {
		ModelAndView mav=new ModelAndView("/err/result");
		mav.addObject("e", e);  //포워딩
		
		return mav;
	}
}
