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

  <!-- CSS 스타일 추가 -->
  <style>
    * { margin: 0; padding: 0; box-sizing: border-box; }

    body {
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      background: linear-gradient(to bottom right, #a1c4fd, #c2e9fb);
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .wrapper {
      background: white;
      padding: 40px;
      border-radius: 20px;
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15);
      text-align: center;
      width: 400px;
    }

    h3 {
      color: #2c3e50;
      margin-bottom: 20px;
    }

    a {
      text-decoration: none;
      color: white;
      background-color: #4a90e2;
      padding: 12px 24px;
      border-radius: 12px;
      display: inline-block;
      margin-top: 20px;
      transition: background-color 0.3s ease;
      font-weight: bold;
    }

    a:hover {
      background-color: #357abd;
    }
  </style>
</head>

<body>
  <%
    request.setCharacterEncoding("utf-8");

    Connection conn = null;
    PreparedStatement pstmt = null;

    String url = "jdbc:mysql://localhost:3306/shopdb";
    String uid = "testuser";
    String pass = "1234";

    String sql = "insert into member values(?, ?, ?, ?, ?, ?)";

    String name = request.getParameter("name");
    String userid = request.getParameter("userid");
    String pwd = request.getParameter("pwd");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    int admin = Integer.parseInt(request.getParameter("admin"));

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection(url, uid, pass);
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, name);
      pstmt.setString(2, userid);
      pstmt.setString(3, pwd);
      pstmt.setString(4, email);
      pstmt.setString(5, phone);
      pstmt.setInt(6, admin);

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
    <a href="01_allMember.jsp">회원 전체 목록 보기</a>
  </div>
</body>
</html>
