<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>

<script type="text/javascript" src="../script/member.js"></script><!-- ..이렇게하면 빠져나가는거-->

</head>
<body>
	<h2>로그인</h2>
	<form action="login.do" method="post" name="frm">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" value="${userid}"></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <!-- 두칸을 합치고 센터로 -->
					<input type="submit" value="로그인" onclick="return loginCheck()"> &nbsp; &nbsp;
					<input type="reset" value="취소"> &nbsp; &nbsp;
					<input type="button" value="회원가입" onclick="location.href='join.do'"> 
				</td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
			
		</table>
	</form>
</body>
</html>