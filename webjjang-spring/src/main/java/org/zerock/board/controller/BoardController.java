package org.zerock.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.board.service.BoardService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

//		private static final Logger log = LoggerFactory.getLogger(BoardController.class);
		
		// 자동 DI
		@Setter(onMethod_ = @Autowired)
		@Qualifier("boardService")
//		@Autowired
		private BoardService service;
		
//		@GetMapping("/board/list.do")
		@GetMapping(value = "/list.do")  // 속성을 더 넣을려면은 value를 쓰면 된다
//		@RequestMapping(value = "/list.do", method = RequestMethod.GET)	// @RequestMapping으로 하기
		public String list(HttpServletRequest request) {
			log.info("list.do");
//			log.info("BoardController.list" + Thread.currentThread().getStackTrace()[1].getMethodName());
//			System.out.println("BoardController.list");
			request.setAttribute("list", service.list());
			
			return "board/list";
		}
		
		@GetMapping(value = "/view.do")
		public String view() {
			
			return "board/view";
		}
		
		@GetMapping(value = "/writeFrom.do")
		public String writeFrom() {
			
			
			return "board/writeFrom";
		}
		
		@PostMapping(value = "/write.do")
		public String write() {
			
			return "board/write";
		}
		
		@GetMapping(value = "updateForm.do")
		public String updateForm() {
			
			return "board/updateForm";
		}
		
		@PostMapping(value = "update.do")
		public String update() {
			
			return "board/update";
		}
		
		@GetMapping(value = "delete.do")
		public String delete() {
			
			return "board/delete";
		}
		
		
		
		
}
