package com.edu.springshop.model.product;

import java.util.List;

import com.edu.springshop.domain.Product;

public interface ProductService {
	public List selectAll();
	public Product select(int product_idx);
	public void regist(Product product, String dir);  //db + file upload+메일+sms,,, 업무가 광범위함
	public void update(Product product);
	public void delete(int product_idx);
}
