package com.edu.springshop.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springshop.domain.Cart;
import com.edu.springshop.domain.Member;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDAO cardDAO;

	@Override
	public List selectAll(Member member) {
		return cardDAO.selectAll(member);
	}

	@Override
	public void insert(Cart cart) {
		cardDAO.insert(cart);
	}

}
