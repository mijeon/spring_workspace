package com.edu.springshop.sns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

/*
	인증화면과 관련된 URL과 파라미터, 토큰을 얻기 위한 URL과 파라미터를 보관할 클래스
	필수는 아니지만, URL과 파라미터가 상당히 복잡하고 길기 때문에 이 클래스를 정의해놓으면 
	링크를 쉽게 관리 할 수 있음
*/
@Data
public class NaverLogin {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	//인증화면 관련 변수
	private String endpoint;  //url 주소
	private String client_id;
	private String client_secret;
	private String redirect_uri;
	private String response_type;
	private String state;  //인증링크에 넘길 주소
	
	//토큰을 위한 변수
	private String token_request_url;
	private String grant_type;
	
	//사용자 정보조회를 위한 변수
	private String userinfo_url;
	
	//스프링 설정파일에서 넘겨받은 정보들을 이용해 인증화면 링크 생성
	public String getGrantUrl() {
		StringBuilder sb=new StringBuilder();
		sb.append(endpoint+"?client_id="+client_id);  //client_id 생성 //get 방식으로 노출되므로 secret은 보여주지 않음
		sb.append("&redirect_uri="+redirect_uri);
		sb.append("&response_type="+response_type);
		sb.append("&state="+state);
		
		return sb.toString();
	}
}