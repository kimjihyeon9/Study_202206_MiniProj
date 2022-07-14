<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
	 	<title>게시판</title>
	</head>
	<body>
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 작성
			</nav>
			<hr />
			
			<section id="container">
				<form role="form-inlin" id="frmSearch" method="post" action="/board/write">
					<input type="hidden" id="startPage" name="startPage" value=""> <!-- 페이징을 위한 hidden타입 추가 -->
					<input type="hidden" id="visiblePages" name="bisiblePages" value=""> <!-- 페이징을 위한 hidden 타입 추가 -->
				
					<table width="1200px">
						<tr>
							<th width="50px">번호</th>
							<th width="850px">제목</th>
							<th width="100px">작성자</th>
							<th width="200px">등록일</th>
						</tr>
						
						<c:choose>
							<c:when test="${fn:length(list) == 0 }">
								<tr>
									<td colspan="4" align="center">
										조회결과가 없습니다.
									</td>
								</tr>
							</c:when>
								
							<c:otherwise>
								<c:forEach items="${list}" var = "list">
									<tr>
										<td><c:out value="${list.bno}" /></td>
										<td><c:out value="${list.title}" /></td>
										<td><c:out value="${list.writer}" /></td>
										<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd"/></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>
