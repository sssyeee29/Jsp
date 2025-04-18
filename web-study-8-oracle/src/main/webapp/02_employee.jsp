<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 가입 완료</title>
</head>

<body>
  <%
    request.setCharacterEncoding("utf-8");

    Connection conn = null;
    PreparedStatement pstmt = null;

    String url = "jdbc:oracle:thin:@localhost:49161:xe";
    String uid = "system";
    String pass = "oracle";

    String sql = "insert into employee values(?, ?, ?)";

    String name = request.getParameter("name");
    String address = request.getParameter("address");
    String ssn = request.getParameter("ssn");
    

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection(url, uid, pass);
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, name);
      pstmt.setString(2, address);
      pstmt.setString(3, ssn);
    

      pstmt.executeUpdate();

    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  %>

  <!-- 스타일이 적용된 회원가입 완료 메시지 -->
  <div class="wrapper">
    <h3>회원 가입이 완료되었습니다 🎉</h3>
    <a href="01_employee.jsp">회원 전체 목록 보기</a>
  </div>
</body>
</html>
