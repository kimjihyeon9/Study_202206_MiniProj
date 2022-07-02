package com.manse.board.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.manse.board.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	SqlSession sql;
	
	private static String namespace = "com.board.mappers.member";

	// ȸ������
	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}

	// �α���
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return sql.selectOne(namespace + ".login", vo);
	}

	// ȸ������ ����
	// ���񽺿��� ���� �Ķ���͵��� memberUpdate(MemberVO vo)�� ��´�
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		// vo�� ��� �Ķ���͵��� memberMapper.xml�� memberMapper��� namespace��
		// ���̵� memberUpdate�� ������ �Ķ���͵��� �־��ش�
		sql.update(namespace + ".memberUpdate", vo);
		
	}

	// ȸ�� Ż��
	// ������Ʈ�� ���������� �帧�� ����
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		// MemberVO�� ��� ������ �����ش�
		// �׷� xml���� memberMapper.memberDelete�� ����
		// #{userId}, #{userPw}�� �Ķ���Ͱ��� ��Ī�� �ɰ��̴�
		sql.delete(namespace + ".memberDelete", vo);
		
	}

	// �н����� üũ
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = sql.selectOne(namespace + ".passChk", vo);
		return result;
	}

}