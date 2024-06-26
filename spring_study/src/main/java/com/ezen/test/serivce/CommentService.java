package com.ezen.test.serivce;

import java.util.List;

import com.ezen.test.domain.CommentVO;

public interface CommentService {

	int post(CommentVO cvo);

	List<CommentVO> getList(int bno);

	int modify(CommentVO cvo);

	int delete(int cno);

}
