package com.ezen.test.serivce;

import com.ezen.test.domain.MemberVO;

public interface MemberService {

	int insert(MemberVO mvo);

	MemberVO isUser(MemberVO mvo);

	void lastLoginUpdate(String id);

	void modify(MemberVO mvo);

	void remove(String id);

}
