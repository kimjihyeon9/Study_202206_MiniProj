package com.manse.board.dao;

import com.manse.board.domain.MemberVO;

public interface MemberDAO {
	// ȸ������
	public void register(MemberVO vo) throws Exception;
}
