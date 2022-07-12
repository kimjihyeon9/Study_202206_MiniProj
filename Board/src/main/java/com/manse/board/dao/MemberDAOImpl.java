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

	// 회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return sql.selectOne(namespace + ".login", vo);
	}

	// 회원정보 수정
	// 서비스에서 보낸 파라미터들을 memberUpdate(MemberVO vo)에 담는다
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		// vo에 담긴 파라미터들은 memberMapper.xml에 memberMapper라는 namespace에
		// 아이디가 memberUpdate인 쿼리에 파라미터들을 넣어준다
		sql.update(namespace + ".memberUpdate", vo);
		
	}

	// 회원 탈퇴
	// 업데이트와 마찬가지로 흐름은 같다
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		// MemberVO에 담긴 값들을 보내준다
		// 그럼 xml에서 memberMapper.memberDelete에 보면
		// #{userId}, #{userPw}에 파라미터값이 매칭이 될것이다
		sql.delete(namespace + ".memberDelete", vo);
		
	}

	// 패스워드 체크
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = sql.selectOne(namespace + ".passChk", vo);
		return result;
	}

	// 아이디 중복 체크
	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = sql.selectOne(namespace + ".idChk", vo);
		return result;
	}

}