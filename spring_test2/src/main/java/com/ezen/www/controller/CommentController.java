package com.ezen.www.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.www.domain.CommentVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.handler.PagingHandler;
import com.ezen.www.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/comment/*")
@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentController {

	private final CommentService csv;
	//ResponseEntity 객체 사용 : body내용 + httpStatus 상태
	//@RequestBody : body 값 추출
	//consumes : @RequestBody에서 가져오는 데이터의 형태
	//produces : 보내는 테이터의 형식 / 나가는 타입 : MediaType
	//json : application/json / text : text_plain
	
	@PostMapping(value = "/post", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> post(@RequestBody CommentVO cvo){
		log.info(">>> cvo >> {}", cvo);
		int isOk = csv.post(cvo);
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK) :
			new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/{bno}/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PagingHandler> list(@PathVariable("bno")int bno, @PathVariable("page")int page){
		//pagingVO / PagingHandler
		PagingVO pgvo = new PagingVO(page, 5);
//		List<CommentVO> list = csv.getList(bno);
		PagingHandler ph = csv.getList(bno, pgvo);
		return new ResponseEntity<PagingHandler>(ph, HttpStatus.OK);
		
		
	}
	

//	@PutMapping(value = "/modify", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<String> modity(@RequestBody CommentVO cvo){
//		log.info(">>> cvo >> {}", cvo);
//		int isOk = csv.modify(cvo);
//		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK) :
//			new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	//responseBody 사용 방식
		@ResponseBody
		@PutMapping("/modify")
		public String modify(@RequestBody CommentVO cvo) {
			log.info(">>> cvo >> {}", cvo);
			int isOk = csv.modify(cvo);
			return isOk> 0 ? "1" : "0";
		}
	
	@DeleteMapping("/{cno}")
	public String delete(@PathVariable("cno")int cno){
		log.info(">>> cno >> {}", cno);
		int isOk = csv.delete(cno);
		return isOk > 0 ? "1" : "0";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
