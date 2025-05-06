package org.zerock.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.board.vo.BoardVO;


@Repository
public interface BoardMapper {
	
	// 일반 게시판 글 리스트
	public List<BoardVO> list();
	
	// 글등록
	public int write(BoardVO vo);
	
	// 글보기
	public BoardVO view(Long no);
	
	// 글보기 조회수 1 증가
	public int inc(Long no);
}
