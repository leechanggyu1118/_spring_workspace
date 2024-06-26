package com.ezen.test.serivce;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.test.domain.CommentVO;
import com.ezen.test.repository.CommentDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	
	private final CommentDAO cdao;

	@Override
	public int post(CommentVO cvo) {
		log.info("commentService in!!!");
		return cdao.post(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info("commentService in!!!");
		return cdao.getList(bno);
	}

	@Override
	public int modify(CommentVO cvo) {
		log.info("commentService in!!!");
		return cdao.modify(cvo);
	}

	@Override
	public int delete(int cno) {
		log.info("commentService in!!!");
		return cdao.delete(cno);
	}
	

}
