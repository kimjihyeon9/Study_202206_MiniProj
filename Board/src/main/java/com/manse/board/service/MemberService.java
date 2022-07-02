package com.manse.board.service;

import com.manse.board.domain.MemberVO;

public interface MemberService {
	// 회원가입 (일반회원가입테이블에 sns계정 컬럼 추가하기)
	// 일반적으로는 DAO랑 같은 메소드명을 사용하여 일관성을 유지한다
	public void register(MemberVO vo) throws Exception;
	
	// 로그인기능 DAO랑 같은 이름으로 하지 않는 이유는?
	//		이름이 달라도 메서드생성가능하다는 걸 보여주기 위해서
//	public MemberVO readMemberWithIDPW(String userId, String userPw) throws Exception;
	
	// 로그인 기능
	public MemberVO login(MemberVO vo) throws Exception;
	
	// 회원정보 수정
	public void memberUpdate(MemberVO vo) throws Exception;
	
	// 회원 탈퇴
	public void memberDelete(MemberVO vo) throws Exception;
}
