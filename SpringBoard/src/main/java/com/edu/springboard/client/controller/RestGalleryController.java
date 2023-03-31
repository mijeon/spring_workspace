package com.edu.springboard.client.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.exception.FileUploadException;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.model.gallery.GalleryService;
import com.google.gson.Gson;

//비동기 응답 데이터
@RestController  //@RestController일 경우 모든 메서드에 @PostMapping 생략가능
public class RestGalleryController {
	Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private GalleryService galleryService;
	
	//갤러리 업로드 요청처리
	@PostMapping("/gallery/regist")
	@ResponseBody  //메서드의 반환값을 jsp로 매핑하지 말고 순수 데이터로 처리하여 응답정보로 보냄
	public String regist(Gallery gallery, HttpServletRequest request) {
		MultipartFile[] photo=gallery.getPhoto();
		
		for(int i=0;i<photo.length;i++) {
			logger.info("업로드된 파일은 "+photo[i].getOriginalFilename());
		}
		
		//3단계) 글 등록하기 (db + file 처리)
		HttpSession httpSession=request.getSession();
		ServletContext application=httpSession.getServletContext();
		String realPath=application.getRealPath("/resources/data/");  //파일 경로 구함
		
		logger.info(realPath);  //파일 경로 확인을 위함
		
		galleryService.regist(gallery, realPath);
		
		return "ok";
	}
	
	//컨트롤러 메서드들에서 예외가 발생했을 경우 처리
	@ExceptionHandler(FileUploadException.class)
	public String handle(FileUploadException e) {
		
		return "error";
	}
	
	@ExceptionHandler(GalleryException.class)
	public ModelAndView handle(GalleryException e) {
		ModelAndView mav=new ModelAndView("/err/result");
		mav.addObject("e", e);  //포워딩
		
		return mav;
	}
	
	//비동기 목록 요청 처리 (주요 클라이언트 : web - ajax)
	//앱 (안드로이드, 아이폰)
	@GetMapping("/rest/gallery/list")
	public List<Gallery> getList() {
		//3단계
		List<Gallery> galleryList=galleryService.selectAll();
		
		return galleryList; 
	}
	
	//갤러리 한건 가져오기
	@GetMapping("/rest/gallery/detail")
	public Gallery getDetail(int gallery_idx) {
		//3단계) 일시키기
		Gallery gallery=galleryService.select(gallery_idx);
		
		return gallery;
	}
	
	@ExceptionHandler(PhotoException.class)
	@ResponseBody
	public ModelAndView handle(PhotoException e) {
		ModelAndView mav=new ModelAndView("/err/result");
		mav.addObject("e", e);  //포워딩
		
		return mav;
	}
}
