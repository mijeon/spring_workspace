package com.edu.springboard.model.gallery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.FileUploadException;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.model.util.FileManager;

@Service
public class GalleryServiceImpl implements GalleryService {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("jdbcGalleryDAO")
	private GalleryDAO galleryDAO;
	
	@Autowired
	@Qualifier("jdbcPhotoDAO")
	private PhotoDAO photoDAO;
	
	@Autowired
	private FileManager fileManager; 
	
	@Override
	public List selectAll() {
		return galleryDAO.selectAll();
	}

	@Override
	public Gallery select(int gallery_idx) {
		return galleryDAO.select(gallery_idx);
	}

	public void regist(Gallery gallery,String path) throws FileUploadException, GalleryException, PhotoException{
        //filemanager일시키기
        fileManager.save(gallery, path);

        //Gallery dao일시키기
        //mybatis의 selectKey에 의해 insert 문 수행 이후에는 Gallery DTO의 gallery_idx의 값이 이미 채워져 있을 것임
        logger.info("insert 이전의 Gallery의 gallery_idx 값"+ gallery.getGallery_idx());
        galleryDAO.insert(gallery);
        logger.info("insert 이후의 Gallery의 gallery_idx 값"+ gallery.getGallery_idx());

        //photo dao일시키기
        //필요한 모든건 Gallery에 다 들어있음
        
        List<Photo> photoList=gallery.getPhotoList();
        //FileManager에 의해 채워진 photoList 이용
        for(int i=0;i<photoList.size();i++) {
        	Photo photo=photoList.get(i);  //하나 꺼내기
        	photo.setGallery(gallery);  //fk를 위해 넣어주기 
        	photoDAO.insert(photo);
        }
    }

	@Override
	public void update(Gallery gallrey) {
		
	}

	@Override
	public void delete(Gallery gallrey) {
		
	}
}
