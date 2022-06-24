package com.manse.board.service;

import java.util.List;

import com.manse.board.domain.BoardVO;

public interface BoardService {
	// �Խù� ���
	public List list() throws Exception;

	// �Խù� �ۼ�
	public void write(BoardVO vo) throws Exception;
	
	// �Խù� ��ȸ
	public BoardVO view(int bno) throws Exception;
}

