package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// Test에 사용되는 클래스
@RunWith(SpringJUnit4ClassRunner.class)
//설정 파일 지정 -> 서버와 상관 없음(서버를 통과하지 않음 즉 servlet-context.xml과 root-context.xml을 거치지 않아 사용하지 않음 ) : 그래서 root-context.xml 사용할수 있게 설정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests_mybatis {

	// 자동 DI - root-context.xml에 bean 태그로 설정
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;  
	
	@Test
	public void testConnection() {
		log.info("---------- [CP테스트] ----------");
		
		// try(resource) -> try가 종료되면 resource 자동 닫기가 된다
		try(Connection conn = dataSource.getConnection()) {
			log.info(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Test
	public void testMybatisConnection() {
		log.info("---------- [Mybatis 테스트] ----------");
		
		// try(resource) -> try가 종료되면 resource 자동 닫기가 된다
		try(SqlSession session = sqlSessionFactory.openSession();
			Connection conn = session.getConnection()) {
			log.info(session);
			log.info(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
//			e.printStackTrace();
		} 
	}
		
}
