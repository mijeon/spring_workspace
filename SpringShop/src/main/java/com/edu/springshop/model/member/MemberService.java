package com.edu.springshop.model.member;


import com.edu.springshop.domain.Member;

public interface MemberService {
	public Member selectById(Member member);
	public void regist(Member member);  //암호화 + 메일발송 + db
}
