package com.edu.springboard.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboard.domain.Notice;
import com.edu.springboard.model.notice.NoticeService;

import oracle.jdbc.proxy.annotation.Post;

@RestController
@RequestMapping("/rest")
public class RestAPINoticeController {
	@Autowired
	private NoticeService noticeService;
	
	//REST를 준수하여 URL 매핑 (RESTful)
	//목록요청 
	@GetMapping("/notices")
	public List<Notice> selectAll() {
		
		return noticeService.selectAll();
	}
	
	//상세요청
	//접근 주소 ex) /notice/23
	@GetMapping("/notices/{notice_idx}")
	public Notice select(@PathVariable("notice_idx") int notice_idx) {  //@PathVariable : 경로가 아닌 변수로 생각함
		
		return noticeService.select(notice_idx);
	}
	
	//삭제요청
	@DeleteMapping("/notices/{notice_idx}")
	public String delete(@PathVariable("notice_idx") int notice_idx) {
		noticeService.delete(notice_idx);
		
		return "ok";
	}
	
	//수정요청
	@PutMapping("/notices")
	public String edit(Notice notice) {
		noticeService.update(notice);
		
		return "ok";
	}
	
	//등록요청
	@PostMapping("/notices")
	public String regist(Notice notice) {
		noticeService.insert(notice);
		
		return "ok";
	}
}
