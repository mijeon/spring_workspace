package com.edu.springshop.admin.controller;


import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.PimgException;
import com.edu.springshop.exception.ProductException;
import com.edu.springshop.exception.UploadException;
import com.edu.springshop.model.product.ProductService;
import com.edu.springshop.util.Message;


//상품과 관련된 요청을 처리하는 하위 컨트롤러
@RestController
@RequestMapping("/rest")
public class RestProductController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//서비스의 존재가 없다면, 컨트롤러 계층과 모델 계층의 구분이 모호해짐
	//추후 모델을 완전히 재사용을 위해 분리시키려고 할 경우 분리 불가능
	@Autowired
	private ProductService productService;
	
	
	//상품 등록 요청 처리
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public ResponseEntity<Message> regist(Product product, HttpServletRequest request) {
		logger.info("Product is "+product);
		
		//웹환경과 관련된 코드이므로, 컨트롤러의 책임임
		//왜? 모델은 중립적이므로 관심이 없음
		ServletContext application=request.getSession().getServletContext();  
		String path=application.getRealPath("/resouces/data/");
		logger.info("저장될 실제 path= "+path);
		logger.info("파라미터는 "+product);
		
		/*
		String product_name = request.getParameter("product_name");
		logger.info("product_name is "+product_name);
		logger.info("product is "+product);
		Message msg = new Message();
		msg.setCode(0);
		msg.setMsg("test");
		*/
		
		//3단계) 일 시키기
		productService.regist(product, path);
		
		Message message = new Message();
		message.setMsg("상품등록 성공");
		
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	
	//제품 목록 요청처리
	@GetMapping("/product")
	public List getList() {
		return productService.selectAll();
	}
	
	@ExceptionHandler(UploadException.class)
	public ResponseEntity<Message> handle(UploadException e){
		Message message=new Message();
		message.setMsg(e.getMessage());
		//message.setMsg("상품 등록 성공");
		
		ResponseEntity entity=new ResponseEntity<Message> (message, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Message> handle(ProductException e){
		Message message=new Message();
		message.setMsg(e.getMessage());
		//message.setMsg("상품 등록 성공");
		
		ResponseEntity entity=new ResponseEntity<Message> (message, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	@ExceptionHandler(PimgException.class)
	public ResponseEntity<Message> handle(PimgException e){
		Message message=new Message();
		message.setMsg(e.getMessage());
		//message.setMsg("상품 등록 성공");
		
		ResponseEntity entity=new ResponseEntity<Message> (message, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
}
