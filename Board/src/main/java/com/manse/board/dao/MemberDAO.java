package com.manse.board.dao;

import com.manse.board.domain.MemberVO;

public interface MemberDAO {
	// ȸ������
	public void register(MemberVO vo) throws Exception;
	
	// �α���
	public MemberVO login(MemberVO vo) throws Exception;
	
	// ȸ������ ����
	public void memberUpdate(MemberVO vo) throws Exception;
	
	// ȸ�� Ż��
	public void memberDelete(MemberVO vo) throws Exception;
	
	// �н����� üũ
	public int passChk(MemberVO vo) throws Exception;
}