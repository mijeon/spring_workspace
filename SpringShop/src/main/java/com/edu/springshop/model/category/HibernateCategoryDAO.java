package com.edu.springshop.model.category;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.springshop.domain.Category;

@Repository
public class HibernateCategoryDAO implements CategoryDAO{

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Category select(int category_idx) {
		return null;
	}

	@Override
	public void insert(Category category) {
		
	}

	@Override
	public void update(Category category) {
		
	}

	@Override
	public void delete(int category_idx) {
		
	}
}
