package com.manse.board.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.manse.board.dao.BoardDAO;
import com.manse.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;

	// �Խù� ���
	public List list() throws Exception {
		
		return dao.list();
	}
	
	// �Խù� �ۼ�
	@Override
	public void write(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.write(vo);
	}

	// �Խù� ��ȸ
	@Override
	public BoardVO view(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.view(bno);
	}

}
