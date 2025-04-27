package org.zerock.sample;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


// Test에 사용되는 클래스
@RunWith(SpringJUnit4ClassRunner.class)
// 설정 파일 지정 -> 서버와 상관 없음(서버를 통과하지 않음 즉 servlet-context.xml과 root-context.xml을 거치지 않아 사용하지 않음 ) : 그래서 root-context.xml 사용할수 있게 설정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

// log 객체 생성 - lombok : log 이름으로 처리
@Log4j
public class SampleTests {
	
	// 레스토랑의 자동 생성과 DI를 확인을 위해 객체 전달 : 자동 DI
	@Setter(onMethod_ = @Autowired)
//	@Setter(onMethod_ = {@Autowired, @Inject})	// spring의 Autowired를 사용해서 안되면은  JAVA의 Inject을 사용 
//	@Autowired
//	@Inject
	private Restaurant restaurant;
	
	// 테스팅할 method 작성 -> 여러개 가능 : 한꺼번에 다 테스트 한다
	@Test
	public void testExist() {
		
	}
}
