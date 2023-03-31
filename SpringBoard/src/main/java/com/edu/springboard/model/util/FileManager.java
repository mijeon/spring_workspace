package com.edu.springboard.model.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.FileUploadException;

@Component
public class FileManager {
	
	//확장자 구하기
	public String getExt(String path) {
		int lastIndex=path.lastIndexOf(".");  //가장 마지막 .의 index 반환
		String ext=path.substring(lastIndex+1, path.length());
		
		return ext;  //확장자 반환
	}
	
	//파일명 얻기
	public String createFileName(String path) {
		long time=System.currentTimeMillis();
		String filename=time+"."+getExt(path);
		return filename;
	}
	
	//서버에 저장
	//서버의 하드디스크 풀경로를 두번째 인수로 넘겨야 함(realPath 넘겨야 함)
	public void save(Gallery gallery, String path) throws FileUploadException {  //Gallery에 MultipartFile이 있으므로
		MultipartFile[] photo=gallery.getPhoto();  //업로드한 파일정보 
		
		//gallery DTO에 비어있는 photoList를 여기서 채우자 -> filename을 만들기 때문에
		List<Photo> photoList=new ArrayList<Photo>();
		gallery.setPhotoList(photoList);
		
		
		try {
			for(int i=0;i<photo.length;i++)  {
				
				try {
					Thread.sleep(10);  //중복된 파일명 방지
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				String filename=createFileName(photo[i].getOriginalFilename());
				Photo dto=new Photo();
				dto.setFilename(filename);
				photoList.add(dto);  //자식에게 파일명 넣어주기
				
				photo[i].transferTo(new File(path+filename));  //(파일 풀경로)
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new FileUploadException("파일저장 실패", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileUploadException("파일저장 실패", e);
		}
	}
}
