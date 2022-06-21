package com.manse.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.manse.board.mappers.board";

	// 게시물 목록
	@Override
	public List list() throws Exception {
		
		return sql.selectList(namespace + ".list");
	}

}
