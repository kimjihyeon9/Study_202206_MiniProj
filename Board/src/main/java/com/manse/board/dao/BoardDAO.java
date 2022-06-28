package com.manse.board.dao;

import java.util.List;

import com.manse.board.domain.BoardVO;

public interface BoardDAO {
	// �Խù� ���
	public List list() throws Exception;
	
	// �Խù� �ۼ�
	public void write(BoardVO vo) throws Exception;
	
	// �Խù� ��ȸ
	public BoardVO view(int bno) throws Exception;
	
	// �Խù� ����
	public void modify(BoardVO vo) throws Exception;
	
	// �Խù� ����
	public void delete(int bno) throws Exception;
	
	// �Խù� �� ����
	public int count() throws Exception;
	
	// �Խù� ��� + ����¡
	public List listPage(int displayPost, int postNum) throws Exception;
	
	// �Խù� ��� + ����¡ + �˻�
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	// �Խù� �� ���� + �˻� ����
	public int searchCount(String searchType, String keyword) throws Exception;
	
	// �Խù� ��ȸ��
	public void updateReviewCnt(int bno) throws Exception;
}
