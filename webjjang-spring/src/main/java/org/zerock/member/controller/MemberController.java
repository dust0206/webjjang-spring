package org.zerock.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.board.service.BoardService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping(value="/selectMemberList.do", method =  RequestMethod.GET)
	public String selectMemberList() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());	// 메소드명 가져오기
		
		
		return "member/selectMemberList";
	}
}
