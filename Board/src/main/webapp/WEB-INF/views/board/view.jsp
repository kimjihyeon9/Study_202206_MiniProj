<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>
<body>

<form method="post">
	<div align="center">
		<table border="1" width="1150px">
			<tr>
				<th width="100px">
					제목
				</th>
				<th width="1050px" align="left">
					<a>${view.title }</a>
				</th>
			</tr>
			
			<tr>
				<th width="100px">
					작성자
				</th>
				<th width="1050px" align="left">
					<a>${view.writer }</a>
				</th>
			</tr>
			
			<tr>
				<th width="100px">
					내용
				</th>
				<th width="1050px" align="left">
					<a>${view.content }</a>
				</th>
			</tr>
		</table>
		<br>
	</div>
	
</form>

</body>
</html>