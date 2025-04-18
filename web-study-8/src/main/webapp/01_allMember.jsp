<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:49161:xe";
	String uid = "system";
	String pass = "oracle";
	String sql = "select * from member";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 목록</title>

  <!-- CSS 스타일 추가 -->
  <style>
    * { margin: 0; padding: 0; box-sizing: border-box; }

    body {
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      font-family: 'Arial', sans-serif;
      background: linear-gradient(to right, #a1c4fd, #c2e9fb);
    }

    .wrapper {
      background: white;
      padding: 40px;
      border-radius: 20px;
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
      width: 900px;
    }

    h2 {
      text-align: center;
      margin-bottom: 30px;
      color: #333;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      text-align: center;
    }

    th, td {
      padding: 12px 16px;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #f0f8ff;
      color: #333;
    }

    tr:hover {
      background-color: #f9f9f9;
    }
  </style>
</head>

<body>
  <div class="wrapper">
    <h2>회원 목록</h2>
    <table>
      <tr>
        <th>이름</th><th>아이디</th><th>암호</th>
        <th>이메일</th><th>전화번호</th><th>권한</th>
      </tr>

      <%
        try {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          conn = DriverManager.getConnection(url, uid, pass);
          stmt = conn.createStatement();
          rs = stmt.executeQuery(sql);

          while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getString("name") + "</td>");
            out.println("<td>" + rs.getString("userid") + "</td>");
            out.println("<td>" + rs.getString("pwd") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("phone") + "</td>");
            out.println("<td>" + rs.getInt("admin") + "</td>");
            out.println("</tr>");
          }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      %>
    </table>
  </div>
</body>
</html>
