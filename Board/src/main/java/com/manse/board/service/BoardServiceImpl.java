package com.manse.board.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.manse.board.dao.BoardDAO;

public class BoardServiceImpl implements BoardDAO {
	
	@Inject
	private BoardDAO dao;

	public List list() throws Exception {
		
		return dao.list();
	}

}
