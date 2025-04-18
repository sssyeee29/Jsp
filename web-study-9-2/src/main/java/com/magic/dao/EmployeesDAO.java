package com.magic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.magic.dto.EmployeesVO;

public class EmployeesDAO {
	
	private static EmployeesDAO instance = new EmployeesDAO();
	
	private EmployeesDAO() {
	}
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	//1. DB 연결
	public Connection getConnection() throws Exception{
		
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String uid = "system";
		String pass = "oracle";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, uid, pass);
		
	}

	public EmployeesVO getMember(String userid) {
		
		EmployeesVO eVo = null;
		
		String sql = "select * from Employees where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String lev = rs.getString("lev");
				String enter = rs.getDate("enter").toString();
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");	
				
				eVo = new EmployeesVO();
				eVo.setId(id);
				eVo.setPass(pass);
				eVo.setName(name);
				eVo.setLev(lev);
				eVo.setEnter(enter.toString());
				eVo.setGender(gender);
				eVo.setPhone(phone);			
			}
		
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return eVo;
		}




}
