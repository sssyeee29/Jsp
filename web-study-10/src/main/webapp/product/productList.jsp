<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>

<div id="wrap" align="center">
  <h1>상품 리스트 - 관리자 페이지</h1>
  <table class="list">
    <thead>
      <tr>
        <th colspan="5" style="border:white; text-align: right">
        <a href="productWrite.do">상품 등록</a></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>번호</td>
        <td>이름</td>
        <td>가격</td>
        <td>수정</td>
        <td>삭제</td>
      </tr>		
      <c:forEach var="product" items="${productList}">
		 <tr class="record">
        	<td>${product.code}</td>
        	<td>${product.name}</td>
        	<td>${product.price}원</td>
        	<td><a href="productUpdate.do?code=${product.code}">상품 수정</a></td>
        	<td><a href="productDelete.do?code=${product.code}">상품 삭제</a></td>
     	 </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
