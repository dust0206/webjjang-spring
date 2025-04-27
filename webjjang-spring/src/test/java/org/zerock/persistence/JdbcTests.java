package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

// DB만 연결
@Log4j
public class JdbcTests {
	
	// JdbcTests 호출이 될때 한번만 실행 - static 초기화 블럭
	static {
		try {
			// 1. 데이터베이스 드라이버 확인
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@Test
	public void testConnection() {
		log.info("testConnection()");
		
		// 2. 데이터 베이스 연결
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//127.0.0.1:1521/XE", "scott", "tiger");
			log.info(conn);
			log.info("연결성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
				 conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
