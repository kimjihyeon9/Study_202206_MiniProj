package com.manse.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.manse.board.dao.MemberDAO;
import com.manse.board.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	// DB와 연결 (의존 주입)
	@Inject
	private MemberDAO mdao;
	
	// 회원가입
	@Override
	public void insertMember(MemberVO vo) {
		// 컨트롤러 -> 서비스 호출 -> DAO 호출 -> Mapper -> DB
		System.out.println("S : 회원가입동작");
		
		if(vo == null) {
			// 처리
			return;
		}
		mdao.insertMember(vo);
	}

	// 로그인 기능
	@Override
	public MemberVO loginMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
