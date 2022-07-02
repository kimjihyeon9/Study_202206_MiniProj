package com.manse.board.service;

import com.manse.board.domain.MemberVO;

public interface MemberService {
	// ȸ������ (�Ϲ�ȸ���������̺� sns���� �÷� �߰��ϱ�)
	// �Ϲ������δ� DAO�� ���� �޼ҵ���� ����Ͽ� �ϰ����� �����Ѵ�
	public void register(MemberVO vo) throws Exception;
	
	// �α��α�� DAO�� ���� �̸����� ���� �ʴ� ������?
	//		�̸��� �޶� �޼�����������ϴٴ� �� �����ֱ� ���ؼ�
//	public MemberVO readMemberWithIDPW(String userId, String userPw) throws Exception;
	
	// �α��� ���
	public MemberVO login(MemberVO vo) throws Exception;
	
	// ȸ������ ����
	public void memberUpdate(MemberVO vo) throws Exception;
	
	// ȸ�� Ż��
	public void memberDelete(MemberVO vo) throws Exception;
}
