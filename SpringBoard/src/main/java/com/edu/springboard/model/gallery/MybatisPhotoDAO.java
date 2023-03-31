package com.edu.springboard.model.gallery;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.PhotoException;

@Repository
public class MybatisPhotoDAO implements PhotoDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTamplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTamplate.selectList("Photo.selectAll");
	}

	@Override
	public Photo select(int photo_idx) {
		return sqlSessionTamplate.selectOne("Photo.select", photo_idx);
	}

	@Override
	public void insert(Photo photo) throws PhotoException{
		int result=0;
		result=sqlSessionTamplate.insert("Photo.insert", photo);
		if(result<1) {
			throw new PhotoException("등록 실패");
		}
	}

	@Override
	public void deleteByGallery(int photo_idx) throws PhotoException {
		int result=0;
		result=sqlSessionTamplate.delete("Photo.insert", photo_idx);
		if(result<1) {
			throw new PhotoException("삭제 실패");
		}
	}
}
