package org.zerock.board.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.board.service.BoardService;
import org.zerock.board.vo.BoardVO;
import org.zerock.page.PageObject;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
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
//		public ModelAndView list() {
		public String list(Model model, HttpServletRequest request) throws Exception {
//		public String list(HttpServletRequest request) {
			log.info("list.do");
//			log.info("BoardController.list" + Thread.currentThread().getStackTrace()[1].getMethodName());
//			System.out.println("BoardController.list");
			
//			 request.setAttribute 에 담기게 된다 
//			request.setAttribute("list", service.list());
//			 return "board/list";
			
			// 페이지 처리를 위한 객체 생성
			PageObject pageObject = PageObject.getInstance(request);
			
			
			// model에 담으면 reqeust에 자동으로 담기게 된다 (reqeustScope에 담기게 된다)
			model.addAttribute("list", service.list(pageObject));
			log.info(pageObject);
			model.addAttribute("pageObject", pageObject);
			return "board/list";
			
			// ModelAndView
//			ModelAndView mav = new ModelAndView();
//			mav.addObject("list", service.list());
//			mav.setViewName("board/list");
//			return mav;
			
		}
		
		// 일반 게시판 글 등록 폼
		@GetMapping(value = "/writeForm.do")
		public String writeFrom() {
			log.info("writeForm.do");
			
			return "/board/writeForm";
		}
		
		// 일반 게시판 글 등록 처리
		@PostMapping(value = "/write.do")
		public String write(BoardVO vo) {
			log.info("write.do");
			log.info(vo);
			service.write(vo);
			return "redirect:list.do";
		}
		
		// 일반 게시판 글보기
		@GetMapping(value = "/view.do")
		public String view(Model model, Long no, int inc) {
			log.info("view.do");
			
			model.addAttribute("vo", service.view(no, inc));
			
			return "board/view";
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
