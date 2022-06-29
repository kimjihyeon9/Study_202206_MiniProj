<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

insertMemver.jsp 이빈다
<h1>views의 폴더명은 컨트롤러의 모듈명과 동일</h1>
<h1> 회원가입 페이지 </h1>

<fieldset>
	<legend> TIWILL 회원가입 </legend>
	<form action="/member/insert" method="post">
		ID : <input type="text" name="userId"><br>
		PW : <input type="password" name="userPw"><br>
		NAME : <input type="text" name="userName"><br>
		EMAIL : <input type="text" name="userEmail"><br>
		
		<input type="submit" value="회원가입">
	</form>
</fieldset>

</body>
</html>