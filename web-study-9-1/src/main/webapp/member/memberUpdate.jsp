<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script type="text/javascript" src="script/member.js"></script> <!-- 유효성체크한다는뜻 -->
</head>
<body>
	<h2>회원 수정</h2>
	 <form method="post" action="memberUpdate.do" name="frm"> 
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" name="name" size="20"
          			value="${mVo.name}" ></td> 
        </tr>
        <tr>
          <td>아이디</td>
          <td>
          	<input type="text" name="userid" size="20" value="${mVo.userid}" readonly> <!-- readonly는 수정불가 -->
 
        </tr>
        <tr>
          	<td>암호</td>
         	<td><input type="password" name="pwd" size="20">*</td>
        </tr>
        <tr height="30">
          	<td width="80">암호 확인</td>
          	<td><input type="password" name="pwd_check" size="20">*</td>
        </tr>
        
        <tr>
          	<td>이메일</td>
          	<td><input type="email" name="email" size="20" value="${mVo.email}"></td>
        </tr>
        <tr>
        	  <td>전화번호</td>
         	 <td><input type="text" name="phone" size="20" value="${mVo.phone}"></td>
        </tr>
        <tr>
          <td>등급</td>
          <td>
          	<c:if test="${mVo.admin==0}">
          		<input type="radio" name="admin" value="1"> 관리자
            	<input type="radio" name="admin" value="0" checked="checked"> 일반회원
            </c:if>
            
            <c:if test="${mVo.admin==1}">
          		<input type="radio" name="admin" value="1" checked="checked"> 관리자
            	<input type="radio" name="admin" value="0"> 일반회원
            </c:if>
            
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
           	 <input type="submit" value="수정" onclick="return joinCheck()"> <!-- 수정누르면 위에 있는 memberUpdate do로 이동 -->
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           	 <input type="reset" value="취소">
          </td>
        </tr>
      </table>
    </form>
</body>
</html>