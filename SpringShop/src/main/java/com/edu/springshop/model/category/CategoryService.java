package com.edu.springshop.model.category;

import java.util.List;

import com.edu.springshop.domain.Category;

//인터페이스는 new가 안돼고 자식을 통해서 메모리에 올라오므로 @(어노테이션) 안해줌
public interface CategoryService {
	public List selectAll();
	public Category select(int category_idx);
	public void insert(Category category);
	public void update(Category category);
	public void delete(int category_idx);	
}
