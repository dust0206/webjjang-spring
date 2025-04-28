package org.zerock.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private Long no;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;		// sql - java.sql.Date : casting이 필요하다 - spring에서는 자동 캐스팅 된다
	private Long hit;
	private String pw;
}
