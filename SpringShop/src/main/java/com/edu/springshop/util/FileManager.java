package com.edu.springshop.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springshop.domain.Pimg;
import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.UploadException;

@Component
public class FileManager {
	private String dir;
	
	//메서드에 의한 주입
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	//파일명 생성하기
	public String createFileName(String filename) {
		long time=System.currentTimeMillis();
		String ext=filename.substring(filename.lastIndexOf(".")+1, filename.length());
		
		return time+"."+ext;
	}
	
	//지정된 디렉토리로 파일 저장
	//dir : 저장될 디렉토리
	public void save(Product product, String dir) throws UploadException{
		MultipartFile[] photoList= product.getPhoto();
		//logger.info("photo 배열은 "+photoList);
		
		//비어있는 pimgList 만들어주기
		List<Pimg> pimgList=new ArrayList<Pimg>();
		product.setPimgList(pimgList);
		
		//그러고 난 다음, pimgList 채우기
		try {
			for(MultipartFile photo:photoList) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Pimg pimg=new Pimg();
				pimg.setProduct(product);  //이 시점에 pk 존재함
				pimg.setFilename(createFileName(photo.getOriginalFilename()));
				
				//리스트에 pimg 추가
				pimgList.add(pimg);
				
				photo.transferTo(new File(dir+pimg.getFilename()));  //(경로)
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
			//예외전환 : 원래 있는 exception 대신 우리가 만든 exception 사용
			throw new UploadException("업로드 실패", e);
		} catch (IOException e) {  
			e.printStackTrace();
			throw new UploadException("업로드 실패", e);
		}
	}
}
