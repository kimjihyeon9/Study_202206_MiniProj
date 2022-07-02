package com.manse.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.manse.board.dao.MemberDAO;
import com.manse.board.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	// DB�� ���� (���� ����)
	@Inject
	private MemberDAO dao;
	
	// ȸ������
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}

	// �α��� ���
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return dao.login(vo);
	}

	// ȸ������ ����
	// Controller���� ������ �Ķ���͵��� memberUpdate(MemberVO vo)�� �ް�
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		// ���� vo�� DAO�� �����ش�
		dao.memberUpdate(vo);
	}

	// ȸ�� Ż��
	// ������Ʈ���� ó���� ����� ����
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		dao.memberDelete(vo);
	}

	// �н����� üũ
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = dao.passChk(vo);
		return result;
	}

	// ���̵� �ߺ� üũ
	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = dao.idChk(vo);
		return result;
	}

}
