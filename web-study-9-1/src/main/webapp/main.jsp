<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty loginUser }">
	<%-- <jsp:forward page="login.do"></jsp:forward> <!-- loginUser가 비워져있으면 login.do로 포워드해서가라 -->--%>

	<script type="text/javascript">
		window.location.href="login.do"; //이걸로 새로운 페이지를 띄우는것 
	</script>

</c:if> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
</head>
<body>
	<h2>회원 전용 페이지</h2>
	<form action="logout.do">
		<table>
			<tr>
				<td>안녕하세요. ${loginUser.name}(${loginUser.userid})님</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그아웃" onclick="location.href='logout.do'" >&nbsp;&nbsp;
					<input type="button" value="회원정보변경"
						onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'"> <!-- 기본키인 userid의 값을 같이가지고 가서 아이디확인 -->
					
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>