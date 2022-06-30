package com.manse.board.dao;

import com.manse.board.domain.MemberVO;

public interface MemberDAO {
	// 회원가입
	public void register(MemberVO vo) throws Exception;
}
