package com.edu.springboard.model.gallery;

import java.util.List;

import com.edu.springboard.domain.Gallery;

//인터페이스는 new가 불가능하므로 @어노테이션을 명시하지 않음
public interface GalleryDAO {
	public List selectAll();
	public Gallery select(int gallery_idx);
	public void insert(Gallery gallery);
	public void update(Gallery gallery);
	public void delete(int gallery_idx);
}
