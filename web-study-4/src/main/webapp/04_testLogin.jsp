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
	String originId = "test";
	String originPwd = "1234";
	String nickName = "sung houn";
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	if(originId.equals(id) && originPwd.equals(pwd)){
		//로그인 성공 -> redirect형식이니까 서버 이동이 생김(다른페이지로 이동)
		response.sendRedirect("04_main.jsp?name=" + nickName); //쿼리스트링형태로 날아감
	}else{
		//로그인 실패
		response.sendRedirect("04_loginForm.jsp"); //실패하면 04_loginForm.jsp 다시 나옴 
	}
%>
</body>
</html>