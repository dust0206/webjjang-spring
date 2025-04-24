package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
// 자동 DI - private 변수가 많을 때 - 한꺼번에 생성자를 이용해서 데이터를 세팅할 수 있다.
// @AllArgsConstructor : 변수가 있는 모든 생성자를 만든가 (lombok)
// @NoArgsConstructor : 기본생성자를 만든가  (lombok)
public class Restaurant {
	
	// 자동  DI - 3가지를 사용할수 있다
	// 		- lombok의 자동 DI를 사용 - (@Setter(onMethod_ =  @Autowired))
	// 		- spring의 자동 DI - @Autowired 사용
	// 		- JAVA에서 사용 패키지는 javax이고 @Inject - 라이브러리가 필요하다(pom.xml의 @Inject)
	//
	// lombok의 Setter를 이용를 이용해서 데이터를 자동 DI 시킬것임
	// spring의 @Autowired 이다
	@Setter(onMethod_ =  @Autowired)
	private Chef chef;
}
