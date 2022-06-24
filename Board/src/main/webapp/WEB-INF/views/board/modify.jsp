<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>

<%-- <div id="nav" align="center">
	<%@ include file="../include/nav.jsp" %>
</div>
<br> --%>

<form method="post">

	<label>제목</label>
	<input type="text" name="title" value="${view.title }"/><br/>
	
	<label>작성자</label>
	<input type="text" name="writer" value="${view.writer }"/><br/>
	
	<label>제목</label>
	<textarea rows="5" cols="50" name="content">${view.content }</textarea><br/>
	
	<button type="submit">완료</button>
	
</form>

</body>
</html>