package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

// 자동 생성을 위한 어노테이션
// - @Controller - url이랑 연관 있음 : HTML, 
// - @Service - 처리랑 연결 되어 있음
// - @Repository - 데이터 저장, dao 저장, 데이터 처리를 위한 저장소, db랑 연결되어 있음
// - @Component - 구성체, 이것도 저것도 아닌데 생성해서 만들어서 써야함, 내 구성원으로 만들어 써야함
// - @RestController - ajax 사용시, REST 방식의 순수한 데이터 통신, JSON 데이터를 주고 받을때, 
//                     url의 주소를 했을때 html이 나오는게 아니라 데이터가 나오게 한다(REST data)
//                     url이랑 연결연결되어 있음 ,  일반적인 data 이고 ajax 처리를 할때 사용
// - @~Advice - 예외처리
@Component
@Data	// setter, getter, toString 자동으로 생성된다, vo 객체
public class Chef {
	
}
