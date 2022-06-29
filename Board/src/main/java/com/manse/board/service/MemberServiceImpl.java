package com.manse.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.manse.board.dao.MemberDAO;
import com.manse.board.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	// DB�� ���� (���� ����)
	@Inject
	private MemberDAO mdao;
	
	// ȸ������
	@Override
	public void insertMember(MemberVO vo) {
		// ��Ʈ�ѷ� -> ���� ȣ�� -> DAO ȣ�� -> Mapper -> DB
		System.out.println("S : ȸ�����Ե���");
		
		if(vo == null) {
			// ó��
			return;
		}
		mdao.insertMember(vo);
	}

	// �α��� ���
	@Override
	public MemberVO loginMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
