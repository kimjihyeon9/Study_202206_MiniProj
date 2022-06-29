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
	// 3-1 ���� ó�� ��ü�� ����(DI)
	@Inject
	private MemberService service;
	
	private static final Logger l = LoggerFactory.getLogger(MemberController.class);
	
	/* ȸ������ ó���ϴ� ���� */
	// insert ��� �ϳ��� �ּҷ� get�� post��� ��, �Է°� ��� �� �� ó�� ����
	
	// http://localhost:8080/test/insert
	// http://localhost:8080/test/member/insert
	// http://localhost:8080/member/insert
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	// value="/memver/insert"���� member�� ���� �ȴ�
	public String inserGET() throws Exception{
		l.info("c: ȸ������ �Է������� GET");
		return "/member/insertMember";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	// value="/memver/insertPro"���� member�� ���� �ȴ�
	public String insertPOST(MemberVO vo) throws Exception{
		// 1. �ѱ� ó�� : request ��ü�� ���� => web.xml ���� filter �±׷� ���ڵ��ؾ��Ѵ�
		
		// 2. ���޵� �Ķ���� �ޱ�
		// request.getParameter ��� ���尴ü�� ����.
		// ���� �޼����� �Ű������� ���� ������ �� �ִ�.
		// l.info("C: " + request.getParameter()); �����߻�
		l.info("C: " + vo);
		
		// 3. ���񽺰�ü ���� (�����������ϰ� ��������)
		// 3-2 ���� ��ü ȣ��
		service.insertMember(vo);
		l.info("C: ȸ������ ó�������� POST");
		
		// 4. �α����������� �̵� ( �ּ��ٰ� view ������ ���ÿ� insert -> login ����Ǿ����)
		return "redirect:/member/login";
	}
}





















