package com.manse.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.manse.board.dao.MemberDAO;
import com.manse.board.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	// DB와 연결 (의존 주입)
	@Inject
	private MemberDAO dao;
	
	// 회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}

	// 로그인 기능
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return dao.login(vo);
	}

	// 회원정보 수정
	// Controller에서 보내는 파라미터들을 memberUpdate(MemberVO vo)로 받고
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		// 받은 vo를 DAO로 보내준다
		dao.memberUpdate(vo);
	}

	// 회원 탈퇴
	// 업테이트에서 처리한 내용와 같다
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		dao.memberDelete(vo);
	}

	// 패스워드 체크
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = dao.passChk(vo);
		return result;
	}

	// 아이디 중복 체크
	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = dao.idChk(vo);
		return result;
	}

}
