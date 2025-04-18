<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/member.js"></script> 
</head>

<body>
	<form action="login.do" method="post" name="frm"></form>
		<div id="box">
			<table border="1" cellpadding="10" align="center" >
				<tr>
					<td> </td>
					<td> </td>
					<td>로그인</td>
					<td>사원등록<br>(관리자로 로그인 후 사용가능)</td>
					<td>마이페이지<br>(로그인 후 사용 가능)</td>
				</tr>
			</table>
		</div>
			<table border="1" cellpadding="10" align="center">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" value="${id}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>레벨</td>
					<td>
						<select name="lev">
							<option value="A">관리자</option>
							<option value="B">일반회원</option>
						</select>
					</td>
				</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" onclick="return loginCheck()"> &nbsp;&nbsp;
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
</body>
</html>