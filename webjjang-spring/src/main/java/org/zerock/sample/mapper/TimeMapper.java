package org.zerock.sample.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


// dao -> 자동 완성 처리 된다
@Repository
public interface TimeMapper {
	
// 1. 어노테이션을 이용해서 여기에다가 실행할 sql query를 만들수 있다.
	// 어노테이션을 이용해서 쿼리 사용
	@Select("select sysdate from dual")
	public String getTime();
	
// 2. xml에다가 실행할 query를 따로 만들어서 처리할수 있다.
	// mapper.xml과 연결되어 잇다.
	public String getTime2();
}
