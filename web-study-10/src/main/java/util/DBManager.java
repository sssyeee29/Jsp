package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		String url = null;
		String uid = null;
		String pass = null;
		
		try { // try catch 구문은 에러를 안전하게 처리하기 위한 구문 
			url = "jdbc:oracle:thin:@localhost:49161:xe";
			uid = "system";
			pass = "oracle";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url, uid, pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return null;
	} //end getConnection -> 자원 반납 //항상 자원을 쓰면 반납해야함 -> close를 써서 반납.
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
