package com.edu.springshop.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.edu.springshop.exception.HashException;

//평문을 해시값으로 변경 (이때 개발자는 알고리즘을 선택할 수 있음) SHA-256
public class PassConverter{
	
	public static String convertHash(String text)  throws HashException {
		StringBuilder sb=new StringBuilder();
		
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-256");
			
			//일반 스트링 쪼개기
			byte[] hash=digest.digest(text.getBytes("utf-8"));
			
			for(int i=0;i<hash.length;i++) {
				//16진수 문자열로 변환 
				String hex=Integer.toHexString(0xff&hash[i]);
				
				//System.out.println(hex);
				if(hex.length()==1) sb.append("0");  //1자리일 경우 0을 붙여서 2자리로 만듬
				sb.append(hex);
			}
			//System.out.println(sb.toString().length());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new HashException("암호화에 실패", e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new HashException("암호화에 실패", e);
		}	
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String hash=convertHash("minzino");
		System.out.println(hash);
	}
}
