package com.edu.springshop.model.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springshop.domain.Cart;
import com.edu.springshop.domain.Member;
import com.edu.springshop.exception.CartException;

@Repository
public class MybatisCartDAO implements CartDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTamplate;
	
	@Override
	public List selectAll(Member member) {
		return sqlSessionTamplate.selectList("Cart.selectAll", member);
	}

	@Override
	public void insert(Cart cart) throws CartException {
		int result=sqlSessionTamplate.insert("Cart.insert", cart);
		if(result<1) {
			throw new CartException("장바구니 등록실패");
		}
	}

	@Override
	public int selectCount(Cart cart) {
		int count=sqlSessionTamplate.selectOne("Cart.selectCount", cart);
		return count;
	}

	@Override
	public void updateEa(Cart cart) throws CartException{
		int result=sqlSessionTamplate.update("Cart.updateEa", cart);
		if(result<1) {
			throw new CartException("장바구니 수정 실패");
		}
	}
}
