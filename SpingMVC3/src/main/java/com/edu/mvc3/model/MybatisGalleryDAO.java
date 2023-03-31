package com.edu.mvc3.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.mvc3.domain.Gallery;
import com.edu.mvc3.exception.GalleryException;

import lombok.Setter;

//component-scan에 의해 검색되어 자동으로 인스턴스 생성됨
@Repository
@Setter
public class MybatisGalleryDAO implements GalleryDAO {
	//이 부분은 스프링이 주도하여 주입시키지 못하고, 아직은 우리가 galleryService에서 주입시켜야 함
	//다음주 스프링이 지원하는 DB연동기술을 배우면 이 문제가 해결됨
	private SqlSession sqlSession;
	
	@Override
	public List selectAll() {
		return sqlSession.selectList("Gallery.selectAll");
	}

	@Override
	public Gallery select(int gallery_idx) {
		return sqlSession.selectOne("Gallery.select", gallery_idx);
	}

	@Override
	public void insert(Gallery gallery) throws GalleryException {
		int result=0;
		result=sqlSession.insert("Gallery.insert", gallery);
		if(result<1) {
			throw new GalleryException("등록 실패");
		}
	}

	@Override
	public void update(Gallery gallery) throws GalleryException {
		int result=0;
		result=sqlSession.update("Gallery.update", gallery);
		if(result<1) {
			throw new GalleryException("수정 실패");
		}
	}

	@Override
	public void delete(int gallery_idx) throws GalleryException {
		int result=0;
		result=sqlSession.delete("Gallery.delete", gallery_idx);
		if(result<1) {
			throw new GalleryException("삭제 실패");
		}
	}
}
