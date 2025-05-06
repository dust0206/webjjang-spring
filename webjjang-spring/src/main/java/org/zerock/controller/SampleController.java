package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

// 자동생성 어노테이션 (이정도는 외워야함)
// @Controller - 동기식 사용, @RestController - uri랑 상관있음 - 비동기식에 많이 사용 => Rest방식의 Restdata는 순수한 text 데이터를 말함(json, xml) - HTML은 아님
// @Service 는 처리에 사용(프로젝트가 작은 범위에서는 사용 안하는 경우도 있음)
// @Repository 데이터 저장에 해당
// @~Advice 예외처리
@Controller		// url이랑 연관되어 있어서  url Mapping을 사용해야 한다.
@RequestMapping("/sample/*")	// /* 은 붙여도 되고 안붙여도 된다	호출방식 : http://localhost:8080/프로젝트명/sample/
//@RequestMapping("/sample")		// 호출방식 : http://localhost:8080/프로젝트명/sample, http://localhost:8080/프로젝트명/sample/
@Log4j 
public class SampleController {
		
	// 브라우저에서 http://localhost:8080/프로젝트명/sample
	@RequestMapping("")		// @RequestMapping은 GET방식이든 POST 방식이든 delete 방식이든 전부다 여기서 실행하라는 의미
	// return이 없으면(void) uri 정보를 jsp 정보로 사용
	// return이 String이면 redirect: -> redirect 시키고 없으면 jsp로 method 명으로 forward 시킨다
	public void basic() {
		log.info("basic()................"); 
	}
	
	// url 매핑이 get과 post 방식만 허용
	@RequestMapping(value = "/basic", method = {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		log.info("basic get/post.................");
	}
	
	// get만 사용. value 속성 하나만 남으면 기본으로 데이터가 들어가는 속성이 되어서 생략가능하다
//	@GetMapping(value = "/basicOnlyGet")
	@GetMapping("/basicOnlyGet")	// value 생략가능
	public void basicGet2() {
		log.info("basic get - only get .................");
	}
	
	@GetMapping("/ex01")
	// property(VO = DTO) 로 넘어오는 데이터 받기 (setter이름과 name 이 같으면 자동으로 받는다
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		// /WEB-INF/view/ + sample/ex01 + .jsp 가 붙여서 완성 된다
		return "sample/ex01";
	}
	
	// get방식 매핑
	@GetMapping("/ex02") 
	// parameter 변수로 받기 - 변수명과 name이 같아야 한다. age가 없으면 오류가 난다.
	// age의 값이 안들어 오면 기본값을 0으로 세팅해서 사용 - @RequestParam을 사용한다.
	// 넘오는 값이 없을경우 기본값으로 만들기 위해서  @RequestParam(defaultValue = "0")을 사용한다. 
	// 		0(int) 은 "0"(String)로 하는 이유는 넘어오는 값이 String이기 때문이다
	
	public String ex02(@RequestParam("name") String name, @RequestParam(defaultValue = "0", name="age") int age) {
		log.info("ex02().name = " + name + ", age = " + age);
		return "ex02";
	}
	
	// get방식 매핑
	@GetMapping("/ex02List") 
	// parameter 변수로 받기 - 아이디 여러개를 받아서 처리 - List / 배열 선언해서 사용 가능
	// @RequestParam 옵션을 주어야 ids 값이 전달된다
	public String ex02List(
			// List로 여러개의 데이터를 받을때는 @RequestParam 이 꼭 필요하다. 없으면 데이터를 안 받는다
			// http://localhost:8080/webjjang-spring/sample/ex02List?ids=aaa&ids=bbb&ids=ccc 파라미터 넘기는 방법
			
			// 배열로 여러개의 데이터를 받을때는 @RequestParam 필요 없음(있어도 되고 없어도 된다)
			// http://localhost:8080/webjjang-spring/sample/ex02List?ids=aaa&ids=bbb&ids=ccc&ids=ddd&names=test&names=test2
			@RequestParam("ids") ArrayList<String> ids, String[] names) {
		log.info("ex02List().ids = " + ids + " , names = " + Arrays.toString(names)); 
		return "ex02List";
	}
	
	// get방식 매핑
	@GetMapping("/ex03")
	// parameter  변수로 날짜 데이터 받기. DTO에  @DateTimeFormat(pattern = "yyyy-MM-dd")
	public String ex03(TodoDTO  dto) {
		log.info("ex03().dto = " + dto);
		return "ex03";
	}
}
