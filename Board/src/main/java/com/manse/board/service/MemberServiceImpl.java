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
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("S : 컨트롤러에서 호출받으면 필요한 정보를 받아서 DAO로 전달");
		MemberVO returnVO = null;
		
		return null;
	}

}
