package com.manse.board.dao;

import java.util.HashMap;
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

	// �Խù� �� ����
	@Override
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");
	}

	// �Խù� ��� + ����¡
	@Override
	public List listPage(int displayPost, int postNum) throws Exception {
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sql.selectList(namespace + ".listPage", data);
	}

	// �Խù� ��� + ����¡ + �˻�
	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectList(namespace + ".listPageSearch", data);
	}

	// �Խù� �� ���� + �˻� ����
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		
		HashMap<String, Object> data =  new HashMap<String, Object>();
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectOne(namespace + ".searchCount", data);
	}

}
