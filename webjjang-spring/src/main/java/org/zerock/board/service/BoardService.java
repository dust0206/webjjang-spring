package org.zerock.board.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

//// 자동 생성을 위한 어노테이션
//- @Controller - 동기식 url, @Service - 처리, @Repository(저장소)-data 저장, 
//  @Component -구성체, @RestController - url:data:ajax, (data를 주고 받을때), @~Advice (에외처리)
@Service
@Log4j
// Type이 같으면 식별할 수 있는 문자열 지정 - 식별할수 있는 id를 지정
@Qualifier("boardService")	// @Qualifier : 예선 통과자 - 여러개중에 한개 통과
public class BoardService {
	
	public void list() {
		log.info("list() 실행 ");
	}
}
