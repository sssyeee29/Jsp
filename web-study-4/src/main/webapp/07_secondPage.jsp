<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>07_secondPage.jsp</h2>
	
	pageContext : <%= pageContext.getAttribute("name") %> <br> <!-- 첫번째 페이지에서만 가능함 -->
	request : <%= request.getAttribute("name") %> <br>
	session : <%= session.getAttribute("name") %> <br>
	application : <%= application.getAttribute("name") %> <br>
	
	<a href="07_thirdPage.jsp">또 다른 페이지</a> <!-- redirect방식 -->
</body>
</html>