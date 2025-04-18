<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>07_thirdPage.jsp</h2>
	
	pageContext : <%= pageContext.getAttribute("name") %> <br> <!-- 첫번째 페이지에서만 가능함 -->
	request : <%= request.getAttribute("name") %> <br> <!-- forward가 아니라 redirect가 돼서 안나옴 -->
	session : <%= session.getAttribute("name") %> <br>
	application : <%= application.getAttribute("name") %> <br>
	
</body>
</html>