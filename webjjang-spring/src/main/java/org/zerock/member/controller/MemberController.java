package org.zerock.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/selectMemberList.do", method =  RequestMethod.GET)
	public String selectMemberList() {
		
		
		return "member/selectMemberList";
	}
}
