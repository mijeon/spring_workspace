package com.edu.springshop.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edu.springshop.domain.Pimg;
import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.PimgException;
import com.edu.springshop.exception.ProductException;
import com.edu.springshop.exception.UploadException;
import com.edu.springshop.util.FileManager;

@Service
public class ProductServiceImpl implements ProductService {
	//DAO 모델
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private PimgDAO pimgDAO;
	
	//FileManager 모델
	@Autowired
	private FileManager fileManager;
	
	 
	
	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}

	@Override
	public Product select(int product_idx) {
		return productDAO.select(product_idx);
	}

	//@Transactional(propagation = Propagation.REQUIRED)  //현재 진행중인 트랜잭션 사용
	@Override
	public void regist(Product product, String dir) throws ProductException, UploadException, PimgException{
		// 상품저장(부모  product)
        productDAO.insert(product);         //select-key 에 의해 fk 존재

        //파일저장
        fileManager.save(product, dir);         // fk가 있는 product

        //이미지 저장(Pimg) //여기서 자식 테이블을 db에 추가함
        List<Pimg> pimgList = product.getPimgList();

        for(Pimg pimg : pimgList) {

             pimgDAO.insert(pimg);
         }
	}

	@Override
	public void update(Product product) throws ProductException{
		productDAO.update(product);
	}

	@Override
	public void delete(int product_idx) throws ProductException{
		productDAO.delete(product_idx);
	}
}
