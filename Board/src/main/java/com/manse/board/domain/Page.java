package com.manse.board.domain;

public class Page {
	// ���� ������ ��ȣ
	private int num;
	
	// �Խù� �� ����
	private int count;
	
	// �� �������� ����� �Խù� ����
	private int postNum = 5;
	
	// �ϴ� ����¡ ��ȣ ([�Խù� �� ���� / �� �������� ����� ����] �� �ø�)
	private int pageNum;
	
	// ����� �Խù�
	private int displayPost;
	
	// �ѹ��� ǥ���� ����¡ ��ȣ�� ����
	private int pageNumCnt = 5;
	
	// ǥ�õǴ� ����¡ ��ȣ �� ������ ��ȣ
	private int endPageNum;
	
	// ǥ�õǴ� ������ ��ȣ �� ù��° ��ȣ
	private int startPageNum;
	
	// ����/���� ǥ�� ����
	private boolean prev;
	private boolean next;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getDisplayPost() {
		return displayPost;
	}
	public void setDisplayPost(int displayPost) {
		this.displayPost = displayPost;
	}
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	public void setPageNumCnt(int pageNumCnt) {
		this.pageNumCnt = pageNumCnt;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public boolean getPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean getNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void setCount(int count) {
		this.count = count;
		
		dataCalc();
	}
	
	private void dataCalc() {
		// ������ ��ȣ
		endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt) * pageNumCnt);
		
		// ���� ��ȣ
		startPageNum = endPageNum - (pageNumCnt -1);
		
		// ������ ��ȣ ����
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNumCnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		prev = startPageNum == 1 ? false : true;
		next = endPageNum * pageNumCnt >= count ? false : true;
		
		displayPost = (num - 1) * postNum;
	}
	
	// �˻� Ÿ�԰� �˻���
/*	private String searchTypeKeyword;
	
	public void serSearchTypeKeyword(String searchType, String keyword) {
		if(searchType.equals("") || keyword.equals("")) {
			searchTypeKeyword = "";
		} else {
			searchTypeKeyword = "&searchType=" + searchType + "&keyword=" + keyword;
		}
	}
	
	public String getSearchTypeKeyword() {
		return searchTypeKeyword;
	} */
	
	private String searchType;
	private String keyword;
	
	public String getSearchTypeKeyword() {
		if(searchType.equals("") || keyword.equals("")) {
			return "";
		} else {
			return "&searchType=" + searchType + "&keyword=" + keyword;
		}
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeyword() {
		return keyword;
	}
}
