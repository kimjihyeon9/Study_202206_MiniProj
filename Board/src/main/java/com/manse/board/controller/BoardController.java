package com.manse.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manse.board.domain.BoardVO;
import com.manse.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	// �Խù� ���
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void getList(Model model) throws Exception{
		List list = null;
		list = service.list();
		
		List<BoardVO> addlist = null;
		addlist = service.list();
		
		for(int i = 0; i < addlist.size(); i++) {
			System.out.println(addlist.get(i).getBno());
			System.out.println(addlist.get(i).getTitle());
			System.out.println(addlist.get(i).getWriter());
			System.out.println(addlist.get(i).getContent());
			System.out.println(addlist.get(i).getRegDate());
		}
		
		model.addAttribute("list", addlist);
	}
	
	// �Խù� �ۼ�
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void getWrite() throws Exception{
		
	}
	
	// �Խù� �ۼ�
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String postwrite(BoardVO vo) throws Exception{
		service.write(vo);
		return "redirect:/board/list";
	}
	
	// �Խù� ��ȸ
	@RequestMapping(value="/view", method= {RequestMethod.GET, RequestMethod.POST})
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception{
		BoardVO vo = service.view(bno);
		model.addAttribute("view", vo);
	}
	
	// �Խù� ����
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception{
		BoardVO vo = service.view(bno);
		model.addAttribute("view", vo);
	}
	
	// �Խù� ����
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String postModify(BoardVO vo) throws Exception{
		service.modify(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	// �Խù� ����
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception{
		service.delete(bno);
		return "redirect:/board/list";
	}
}
