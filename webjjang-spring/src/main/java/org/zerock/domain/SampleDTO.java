package org.zerock.domain;

import lombok.Data;

@Data	// lombok을 이용해서 getter, setter, toString 메소드를 자동으로 생성
public class SampleDTO {
	
	private String name;
	private int age;
	
}
