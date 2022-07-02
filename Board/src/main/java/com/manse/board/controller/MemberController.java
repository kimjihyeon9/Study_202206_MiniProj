package com.manse.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manse.board.domain.MemberVO;
import com.manse.board.service.MemberService;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService service;
	
	// ȸ������ get
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void getRegister() throws Exception{
		logger.info("get register");
	}
	
	// ȸ������ post
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception{
		logger.info("post register");
		service.register(vo);
		
		return "redirect:/";
	}
	
	// �α��� post
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		// session : ���귯������ �������� ������¸� �ǹ�
		// httpSession : Ŭ���̾�Ʈ�� ���������� �������� ���� ���¸� �����ϴ� ��ü
		
		logger.info("post login");
		
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", login);
		}
		return "redirect:/";
	}
	
	// �α׾ƿ�
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:/";
	}
	
	// ȸ������ ����
	@RequestMapping(value="/memberUpdateView", method=RequestMethod.GET)
	public String registerUpdateView() throws Exception{
		return "member/memberUpdateView";
	}
	
	// ȸ������ ����
	@RequestMapping(value="/memberUpdate", method=RequestMethod.POST)
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{
		service.memberUpdate(vo);
		session.invalidate();
		
		return "redirect:/";
	}
	
	// ȸ�� Ż�� get
	@RequestMapping(value="/memberDeleteView", method=RequestMethod.GET)
	public String memberDeleteView() throws Exception{
		return "member/memberDeleteView";
	}
	
	// ȸ�� Ż�� post
	@RequestMapping(value="/memberDelete", method=RequestMethod.POST)
	public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		// ���ǿ� �ִ� member�� ������ member������ �־��ش�
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		// ���ǿ� �ִ� ��й�ȣ
		String sessionPw = member.getUserPw();
		
		// vo�� ������ ��й�ȣ
		String voPw = vo.getUserPw();
		
		if(!(sessionPw.equals(voPw))) {
			rttr.addFlashAttribute("msg", false);
			
			return "redirect:/member/memberDeleteView";
		}
		
		service.memberDelete(vo);
		session.invalidate();
		return "redirect:/";
	}
	
	// �н����� üũ
	@ResponseBody
	@RequestMapping(value="/passChk", method=RequestMethod.POST)
	public int passChk(MemberVO vo) throws Exception{
		int result = service.passChk(vo);
		return result;
	}
}




