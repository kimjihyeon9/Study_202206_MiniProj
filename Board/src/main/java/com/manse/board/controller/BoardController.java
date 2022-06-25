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
	
	// �Խù� ��� + ����¡ �߰�
	@RequestMapping(value="/listpage", method=RequestMethod.GET)
	public void getListPage(Model model) throws Exception{
		List list = null;
		list = service.list();
		model.addAttribute("list", list);
	}
	
	// �Խù� ��� + ����¡ �߰�
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception{
		// �Խù� �� ����
		int count = service.count();
		
		// �� �������� ����� �Խù� ����
		int postNum = 5;
		
		// �ϴ� ����¡ ��ȣ ([�Խù� �� ���� / �� �������� ����� ���� ] �� �ø�)
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		// ����� �Խù�
		int displayPost = (num - 1) * postNum;
		
		
		
		// �ѹ��� ǥ���� ����¡ ��ȣ�� ����
		int pageNum_cnt = 5;
		
		// ǥ�õǴ� ������ ��ȣ �� ������ ��ȣ
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		
		// ǥ�õǴ� ������ ��ȣ �� ù��° ��ȣ
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// ������ ��ȣ ����
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		
		List list = null;
		list = service.listPage(displayPost, postNum);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		
		// ���� �� �� ��ȣ
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		// ���� �� ����
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		// ���� ������
		model.addAttribute("select", num);
	}
}
