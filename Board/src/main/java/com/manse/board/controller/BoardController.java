package com.manse.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manse.board.domain.BoardVO;
import com.manse.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
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
}
