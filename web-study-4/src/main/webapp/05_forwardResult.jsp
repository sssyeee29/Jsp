<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	String name = (String)request.getAttribute("name"); //반환타입이 object라서 string으로 형변환 // setAttribute 한 걸 읽어올거니까 getAttribute로 써야함 
%>

이름은 <%= name %>이고, 나이는 <%=age %>입니다.
</body>
</html>