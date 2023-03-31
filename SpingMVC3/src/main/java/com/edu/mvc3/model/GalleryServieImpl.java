package com.edu.mvc3.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.mvc3.domain.Gallery;

@Service
public class GalleryServieImpl implements GalleryService{
	
	@Autowired
	private GalleryDAO galleryDAO;
	
	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Gallery select(int gallery_idx) {
		return null;
	}

	//파일 저장 + DB insert
	@Override
	public void regist(Gallery gallery) {
		//FileManager
		
		//GalleryDAO
	}

	@Override
	public void update(Gallery gallery) {
		
	}

	@Override
	public void delete(int gallery_idx) {
		
	}

}
