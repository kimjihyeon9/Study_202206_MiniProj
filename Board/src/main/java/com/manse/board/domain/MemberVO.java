package com.manse.board.domain;

import java.util.Date;

/*

use board;

create table tbl_member(
userId int(11) not null auto_increment,
userPw varchar(100) not null,
userName varchar(40) not null,
regDate timestamp not null default now(),
primary key(userId)
);


 */

public class MemberVO {
	private String userId;
	private String userPw;
	private String userName;
	private Date regDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [ userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", regDate=" + regDate
				+ " ]";
	}
	
}
