<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello</h1>
	<form action="ParamServlet" method="get" name="frm">
		아이디 : <input type="text" name="id"><br>
		나 이 : <input type="text" name="age"><br>
		<input type="submit" value = "전송" onclick="return check()">
	</form>
	
	<script type="text/javascript" src="./param.js"></script>
</body>
</html>