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
	session.invalidate(); //세션삭제 
%>

	<script type="text/javascript">
		alert("로그아웃 되었습니다."); //이 창이 바로 뜬다. 
		location.href="10_loginForm.jsp";
	</script>
</body>
</html>