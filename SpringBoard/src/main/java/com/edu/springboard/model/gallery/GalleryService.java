package com.edu.springboard.model.gallery;

import java.util.List;

import com.edu.springboard.domain.Gallery;

public interface GalleryService {
	public List selectAll();  //dao 동일
	public Gallery select(int gallery_idx);  //dao 동일
	public void regist(Gallery gallery, String path);  //insert + upload
	public void update(Gallery gallrey);  //dao와 다름 (이미지 / db 수정)
	public void delete(Gallery gallrey);  //이미지 / db 삭제
}
