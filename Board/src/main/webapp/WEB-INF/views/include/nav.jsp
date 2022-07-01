<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- <ul>
	<li>
		<a href="/board/list">글 목록</a>
	</li>

	<li>
		<a href="/board/write">글 작성</a>
	</li>
</ul> -->

<button><a href="/board/write">글 작성</a></button>
<button><a href="/board/list">글 목록</a></button>
<button><a href="/board/listPage?num=1">글 목록(페이징)</a></button>
<button><a href="/board/listPageSearch?num=1">글 목록(페이징 + 검색)</a></button>
<br><br>

<c:if test="${member != null }"><a href="/member/logout">로그아웃</a></c:if>
<c:if test="${member == null }"><a href="/member/login">로그인</a></c:if>
<c:if test="${member != null }">
	<p>${member.userId }님 안녕하세요.</p>
</c:if>