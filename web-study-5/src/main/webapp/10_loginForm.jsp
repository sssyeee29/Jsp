<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="10_testLogin.jsp">
		아이디 : <input type = "text" name="id"><br> <!-- input type=text가 아이디 입력 박스 만듦 -->
		암호 : <input type = "text" name="pwd"><br> <!-- type에 text대신 password 쓰면 ****안보이게 쓰여짐 -->
		<input type="submit" value="로그인">
	</form>
</body>
</html>