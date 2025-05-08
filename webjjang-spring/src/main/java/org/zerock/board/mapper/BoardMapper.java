package org.zerock.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.board.vo.BoardVO;
import org.zerock.page.PageObject;



@Repository
public interface BoardMapper {
	
	// 일반 게시판 글 리스트
	public List<BoardVO> list(PageObject pageObject);
	
	// 일반 게시판 리스트 페이지 처리를 위한 전체 데이터 갯수 
	public Long getTotalRow(PageObject pageObject);
	
	// 글등록
	public int write(BoardVO vo);
	
	// 글보기
	public BoardVO view(Long no);
	
	// 글보기 조회수 1 증가
	public int increase(Long no);
}
