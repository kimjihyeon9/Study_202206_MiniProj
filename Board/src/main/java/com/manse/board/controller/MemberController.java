package com.manse.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manse.board.domain.MemberVO;
import com.manse.board.service.MemberService;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	// 3-1 서비스 처리 객체를 주입(DI)
	@Inject
	private MemberService service;
	
	private static final Logger l = LoggerFactory.getLogger(MemberController.class);
	
	/* 회원가입 처리하는 동작 */
	// insert 라는 하나의 주소로 get과 post방식 즉, 입력과 출력 둘 다 처리 가능
	
	// http://localhost:8080/test/insert
	// http://localhost:8080/test/member/insert
	// http://localhost:8080/member/insert
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	// value="/memver/insert"에서 member를 빼도 된다
	public String inserGET() throws Exception{
		l.info("c: 회원가입 입력페이지 GET");
		return "/member/insertMember";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	// value="/memver/insertPro"에서 member를 뺴도 된다
	public String insertPOST(MemberVO vo) throws Exception{
		// 1. 한글 처리 : request 객체가 없다 => web.xml 에서 filter 태그로 인코딩해야한다
		
		// 2. 전달된 파라미터 받기
		// request.getParameter 라는 내장객체가 없다.
		// 따라서 메서드의 매개변수를 통해 가져올 수 있다.
		// l.info("C: " + request.getParameter()); 에러발생
		l.info("C: " + vo);
		
		// 3. 서비스객체 생성 (직접생성안하고 의존주입)
		// 3-2 서비스 객체 호출
		service.insertMember(vo);
		l.info("C: 회원가입 처리페이지 POST");
		
		// 4. 로그인페이지로 이동 ( 주소줄과 view 페이지 동시에 insert -> login 변경되어야함)
		return "redirect:/member/login";
	}
}





















