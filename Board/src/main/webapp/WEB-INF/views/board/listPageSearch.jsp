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

<form class="form-inlin" id="frmSearch" action="/board/list">
	<input type="hidden" id="startPage" name="startPage" value=""> <!-- 페이징을 위한 hidden타입 추가 -->
	<input type="hidden" id="visiblePages" name="bisiblePages" value=""> <!-- 페이징을 위한 hidden 타입 추가 -->
	
	<div align="center">
		
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
		
		<div>
			<c:if test="${page.prev }">
				<span>[ <a href="/board/listPageSearch?num=${page.startPageNum - 1 }">이전</a> ]</span>
			</c:if>
			
			<c:forEach begin="${page.startPageNum }" end="${page.endPageNum }" var="num">
				<span>
				<c:choose>
					<c:when test="${num == select }">
						<b>${num }</b>
					</c:when>
					<c:otherwise>
						<a href="/board/listPageSearch?num=${num }">${num }	</a>
					</c:otherwise>
				</c:choose>
				</span>
			</c:forEach>
			
			<c:if test="${page.next }">
				<span>[ <a href="/board/listPageSearch?num=${page.endPageNum + 1 }">다음</a> ]</span>
			</c:if>
			
			<div>
				<select name="searchType">
			    	<option value="title" <c:if test="${page.searchType eq 'title'}">selected</c:if>>제목</option>
			        <option value="content" <c:if test="${page.searchType eq 'content'}">selected</c:if>>내용</option>
			     	<option value="title_content" <c:if test="${page.searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
			     	<option value="writer" <c:if test="${page.searchType eq 'writer'}">selected</c:if>>작성자</option>
				</select>
			  
			  <input type="text" name="keyword" value="${page.keyword }" />
			  
			  <button type="button" id="searchBtn">검색</button>
			</div>
		</div>
	</div>
</form>

<script>

 document.getElementById("searchBtn").onclick = function () {
    
  let searchType = document.getElementsByName("searchType")[0].value;
  let keyword =  document.getElementsByName("keyword")[0].value;
  
  console.log(searchType)
  console.log(keyword)

  location.href = "/board/listPageSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
 };
</script>

</body>
</html>