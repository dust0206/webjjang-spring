package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.sample.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// Test에 사용되는 클래스
@RunWith(SpringJUnit4ClassRunner.class)
//설정 파일 지정 -> 서버와 상관 없음(서버를 통과하지 않음 즉 servlet-context.xml과 root-context.xml을 거치지 않아 사용하지 않음 ) : 그래서 root-context.xml 사용할수 있게 설정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTest {

	// 자동 DI - root-context.xml에 bean 태그로 설정
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;

	@Test
	public void testGetTime() {
		log.info("---------- [Mapper 어노테이션 테스트] ----------");
		
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info("---------- [Mapper XML 테스트] ----------");
		
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
	
}
