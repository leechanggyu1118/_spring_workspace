package com.ezen.www.repository;

import java.util.List;

import com.ezen.www.domain.AuthVO;
import com.ezen.www.domain.UserVO;

public interface UserDAO {

	int insert(UserVO uvo);

	int insertAuthInit(String email);

	UserVO selectEmail(String username);

	List<AuthVO> selectAuths(String username);

	int updateLastLogin(String authEmail);

	List<UserVO> getUserList();

	void userModify(UserVO uvo);

	void userPwdModify(UserVO uvo);

	void userAuthDelete(String email);

	void userDelete(String email);

	int checkEmail(String email);


	

	

	

	

}
