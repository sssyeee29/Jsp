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
//	String url = "jdbc:mysql://localhost:3306/shopdb";
	String uid = "system";
	String pass = "oracle";
	String sql = "select * from employee";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 목록</title>

</head>

<body>
  <div class="wrapper">
    <h2>회원 목록</h2>
    <table border="1">
      <tr>
        <th>이름</th><th>주소</th><th>주민번호</th>
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
            out.println("<td>" + rs.getString("address") + "</td>");
            out.println("<td>" + rs.getString("ssn") + "</td>");
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
