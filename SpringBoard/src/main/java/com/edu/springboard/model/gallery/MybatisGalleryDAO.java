package com.edu.springboard.model.gallery;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.exception.GalleryException;

@Repository
public class MybatisGalleryDAO implements GalleryDAO{
	//mybatis-spring에서는 기존 Mybatis 의 쿼리 담당 객체였던 SqlSession이 SqlSessionTemplate으로 변경됨
	@Autowired
	private SqlSessionTemplate sqlSessionTamplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTamplate.selectList("Gallery.selectAll");
	}

	@Override
	public Gallery select(int gallery_idx) {
		return sqlSessionTamplate.selectOne("Gallery.select", gallery_idx);
	}

	@Override
	public void insert(Gallery gallery) throws GalleryException{
		int result=0;
		result=sqlSessionTamplate.insert("Gallery.insert", gallery);
		if(result<1) {
			throw new GalleryException("등록 실패");
		}
	}

	@Override
	public void update(Gallery gallery) throws GalleryException {
		int result=0;
		result=sqlSessionTamplate.update("Gallery.insert", gallery);
		if(result<1) {
			throw new GalleryException("수정 실패");
		}
	}

	@Override
	public void delete(int gallery_idx) throws GalleryException {
		int result=0;
		result=sqlSessionTamplate.delete("Gallery.delete", gallery_idx);
		if(result<1) {
			throw new GalleryException("삭제 실패");
		}
	}
}
