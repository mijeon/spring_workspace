package com.edu.springshop.model.member;


import com.edu.springshop.domain.Member;

public interface MemberDAO {
	public Member selectById(Member member);
	public void insert(Member member);
}
