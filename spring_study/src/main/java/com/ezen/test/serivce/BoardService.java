package com.ezen.test.serivce;

import java.util.List;

import com.ezen.test.domain.BoardDTO;
import com.ezen.test.domain.BoardVO;
import com.ezen.test.domain.PagingVO;

public interface BoardService {

	int insert(BoardDTO bdto);

	List<BoardVO> getList(PagingVO pgvo);

	BoardDTO getDetail(int bno);

	void update(BoardVO bvo);

	void remove(int bno);

	int getTotal(PagingVO pgvo);





}
