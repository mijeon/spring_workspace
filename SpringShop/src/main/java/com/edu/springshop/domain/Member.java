package com.edu.springshop.domain;

import lombok.Data;

@Data
public class Member {
	private int member_idx;
	private String uid;  //sns 공통
	private String nickname;  //sns 공통
	private String regdate;
	private SnS sns;  //부모를 has a 관계로 보유 (association 대상)
}
