<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 리스트</title>
</head>
<body>

<div id="nav" align="center">
	<%@ include file="../include/nav.jsp" %>
</div>
<br>

<%-- <table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${list }" var="list">
			<tr>
				<td>${list.bno }</td>
				<td>${list.title }</td>
				<td>${list.regDate }</td>
				<td>${list.writer }</td>
				<td>${list.viewCnt }</td>
			</tr>
		</c:forEach>
	</tbody>
</table> --%>

<form class="form-inlin" id="frmSearch" action="/board/list">
	<input type="hidden" id="startPage" name="startPage" value=""> <!-- 페이징을 위한 hidden타입 추가 -->
	<input type="hidden" id="visiblePages" name="bisiblePages" value=""> <!-- 페이징을 위한 hidden 타입 추가 -->
	
	<div align="center">
		<!-- <table width="1200px">
			<tr>
				<td aling="right">
					<button type="button" id="write" name="write"><a href="/board/write">글 작성</a></button>
				</td>
			</tr>
		</table> -->
		
		<table border="" width="1200px">
			<tr>
				<th width="50px">
					No
				</th>
				<th width="850px">
					제목
				</th>
				<th width="100px">
					작성자
				</th>
				<th width="200px">
					작성일
				</th>
				<th width="200px">
					조회수
				</th>
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
					<c:forEach var="list" items="${list }" varStatus="status">
						<tr>
							<td align="center">${list.bno }</td>
							<td>
							    <a href="/board/view?bno=${list.bno}">${list.title}</a>
							</td>
							<td align="center">${list.writer }</td>
							<td align="center"><fmt:formatDate value="${list.regDate }" pattern="yyyy-MM-dd"/></td>
							<td align="center">${list.viewCnt }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<br>
		
		<%-- <div>
			<c:forEach begin="1" end="${pageNum }" var="num">
				<span>
					<a href="/board/listPage?num=${num }">${num }</a>
				</span>
			</c:forEach>
		</div> --%>
		<div>
			<c:if test="${prev }">
				<span>[ <a href="/board/listPage?num=${startPageNum - 1 }">이전</a> ]</span>
			</c:if>
			
			<c:forEach begin="${startPageNum }" end="${endPageNum }" var="num">
				<span>
				<c:choose>
					<c:when test="${num == select }">
						<b>${num }</b>
					</c:when>
					<c:otherwise>
						<a href="/board/listPage?num=${num }">${num }	</a>
					</c:otherwise>
				</c:choose>
				<%-- 
					<c:if test="${select != null }">
						<a href="/board/listPage?num=${num }">${num }</a>
					</c:if>
					
					<c:if test="${select == num }">
						<b>${num }</b>
					</c:if> --%>
				</span>
			</c:forEach>
			
			<c:if test="${next }">
				<span>[ <a href="/board/listPage?num=${endPageNum + 1 }">다음</a>]</span>
			</c:if>
		</div>
	</div>
</form>

</body>
</html>