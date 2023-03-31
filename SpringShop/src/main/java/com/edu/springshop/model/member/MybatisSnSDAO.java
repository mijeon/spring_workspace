package com.edu.springshop.model.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springshop.domain.SnS;

@Service
public class MybatisSnSDAO implements SnSDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTamplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTamplate.selectList("SnS.selectAll");
	}

	@Override
	public SnS selectByIdx(int sns_idx) {
		return sqlSessionTamplate.selectOne("SnS.selectByIdx", sns_idx);
	}

	@Override
	public SnS selectByName(String sns_name) {
		return sqlSessionTamplate.selectOne("SnS.selectByName", sns_name);
	}

}
