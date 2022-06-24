package com.manse.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manse.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.board";

	// �Խù� ���
	@Override
	public List list() throws Exception {
		
		return sql.selectList(namespace + ".list");
	}

	// �Խù� �ۼ�
	@Override
	public void write(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".write", vo);
	}

	// �Խù� ��ȸ
	@Override
	public BoardVO view(int bno) throws Exception {
		
		return sql.selectOne(namespace + ".view", bno);
	}

	// �Խù� ����
	@Override
	public void modify(BoardVO vo) throws Exception {
		
		sql.update(namespace + ".modify", vo);
	}

	// �Խù� ����
	@Override
	public void delete(int bno) throws Exception {
		sql.delete(namespace + ".delete", bno);
	}

}
