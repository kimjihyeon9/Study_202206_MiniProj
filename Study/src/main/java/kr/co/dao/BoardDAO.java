package kr.co.dao;

import java.util.List;

import kr.co.vo.BoardVO;

public interface BoardDAO {
	
	// 게시글 작성
	public void writer(BoardVO boardVO) throws Exception;
	
	// 게시물 목록 조회
	public List<BoardVO> list() throws Exception;
	
	// 게시물 조회
	public BoardVO read(int bno) throws Exception;
}
