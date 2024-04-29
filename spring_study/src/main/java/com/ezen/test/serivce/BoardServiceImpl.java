package com.ezen.test.serivce;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.test.domain.BoardDTO;
import com.ezen.test.domain.BoardVO;
import com.ezen.test.domain.FileVO;
import com.ezen.test.domain.PagingVO;
import com.ezen.test.repository.BoardDAO;
import com.ezen.test.repository.FileDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

	private final BoardDAO bdao;
	private final FileDAO fdao;
	@Override
	public int insert(BoardDTO bdto) {
		log.info(">>> board register service check!!");
		int isOk = bdao.insert(bdto.getBvo());
		
		//file 처리 => bno는 아직 없음.
		if(bdto.getFlist() == null) {
			return isOk;
		}else {
			// 파일 저장
			if(isOk > 0 && bdto.getFlist().size() > 0) {
				//bno는 아직 없음. insert를 통해 자동생성 => DB에 가서 검색해오기.
				int bno = bdao.selectBno();
				for(FileVO fvo : bdto.getFlist()) {
					fvo.setBno(bno);
					//파일 저장
					isOk *= fdao.insertFile(fvo);
				}
			}
		}
		
		
		return isOk;
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info(">>> board list service check!!");
		return bdao.getlist(pgvo);
	}

	@Override
	public BoardDTO getDetail(int bno) {
		log.info(">>> board detail service check!!");
		//read_Count 증가
		bdao.updateReadCount(bno);
		BoardDTO bdto = new BoardDTO();
		BoardVO bvo = bdao.getDetail(bno); //기존에 처리된 bvo 객체
		bdto.setBvo(bvo);
		bdto.setFlist(fdao.getFileList(bno)); //bno에 해당하는 모든 파일 리스트 검색
		return bdto;
	}

	@Override
	public void update(BoardVO bvo) {
		log.info(">>> board update service check!!");
		bdao.update(bvo);
		
	}

	@Override
	public void remove(int bno) {
		log.info(">>> board remove service check!!");
		bdao.remove(bno);
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		log.info(">>> board getTotal service check!!");
		return bdao.getTotal(pgvo);
	}




}