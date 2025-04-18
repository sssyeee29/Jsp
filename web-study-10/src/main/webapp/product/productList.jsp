<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
  <h1>상품 리스트 - 관리자 페이지</h1>
  <table class="table">
    <thead>
      <tr>
        <th colspan="5" align="center">상품 등록</th>
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
		 <tr>
        	<td>${product.code}</td>
        	<td>${product.name}</td>
        	<td>${product.price}</td>
        	<td>상품 수정</td>
        	<td>상품 삭제</td>
     	 </tr>
      </c:forEach>
      <tr>
      	<td colspan="5">
			
      	</td>
      </tr>
    </tbody>
  </table>
</div>

</body>
</html>
