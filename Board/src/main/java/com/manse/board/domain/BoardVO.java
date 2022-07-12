package com.manse.board.domain;

import java.sql.Date;

/*
create database board;

use board;

create table tbl_board(
bno int not null auto_increment,
title varchar(50) not null,
content text not null,
writer varchar(30) not null,
regDate timestamp not null default now(),
viewCnt int default 0,
primary key(bno)
);

insert into tbl_board(title, content, writer)
  values('테스트 제목1', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목2', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목3', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목4', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목5', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목6', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목7', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목8', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목9', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목10', '테스트 내용', '작성자');

 insert into tbl_board(title, content, writer)
  values('테스트 제목11', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목12', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목13', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목14', '테스트 내용', '작성자');

insert into tbl_board(title, content, writer)
  values('테스트 제목15', '테스트 제내용목', '작성자');

commit;

select * from tbl_board;
*/
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

}
