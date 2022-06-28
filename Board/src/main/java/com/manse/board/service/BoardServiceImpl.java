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
		dao.updateReviewCnt(bno);
		return dao.view(bno);
	}

	// �Խù� ����
	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.modify(vo);
	}

	// �Խù� ����
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}

	// �Խù� �� ����
	@Override
	public int count() throws Exception {
		return dao.count();
	}

	// �Խù� ��� + ����¡
	@Override
	public List listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);
	}

	// �Խù� ��� + ����¡ + �˻�
	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		return dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}

	// �Խù� �� ����
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		return dao.searchCount(searchType, keyword);
	}
	
}
