package com.manse.board.service;

import java.util.List;

import com.manse.board.domain.BoardVO;

public interface BoardService {
	// 게시물 목록
	public List list() throws Exception;

	// 게시물 작성
	public void write(BoardVO vo) throws Exception;
}

