package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saeyan.dto.MemberVO;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {	
	}
	
	public static MemberDAO getInstance() {
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
	//userid, pwd 전달받아서 DB랑 연동해서 데이터가 있는지 조회
	public int userCheck(String userid, String pwd) { //반환타입이 정수(숫자)니까 int로 해줘야함 
		
		/*
		 * 1 : userid, pwd 일치
		 * 0 : userid 일치, pwd 불일치
		 *-1 : userid 불일치 
		 */
		
		int result = -1;
		
		String sql = "select pwd from member where userid = ?"; //oracle에 이 문장치면 ?대신 free쓰면 아무것도 안나옴 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //sql구문이 select일때만 기입!
		
		try {
			//1. DB연결 -> 21번으로가서 연결되는거
			conn = getConnection();
			//2. sql구문 전송
			pstmt = conn.prepareStatement(sql);
			//3. sql 맵핑  //42번째줄 ?로 미완성이라서 그걸 완성시키는 과정
			pstmt.setString(1, userid); 
			//4. sql 구문 실행
			rs = pstmt.executeQuery(); //sql구문이 select일때만
	
			if(rs.next()) {  //if는 값이 있냐고 묻는것
				//userid 존재하면 이곳 
				if(rs.getString("pwd") != null && //가져온 pwd가 맞는건지 안전하게(?) 검사하는 코드 
						rs.getString("pwd").equals(pwd)) { //가져온 pwd랑 입력한 pwd가 같으면 1이 출력 
					result = 1; //userid, pwd 일치
				}else {
					result = 0; //pwd만 불일치
				}
			}else {
				//회원id가 없으면 이곳 실행
				result = -1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { //항상 close 할때는 위에 연결했던 순서 반대로 닫아줘야함(최근꺼부터 닫아줘야함)
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public MemberVO getMember(String userid) {
		
		MemberVO mVo = null;
		
		String sql = "select * from member where userid = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery(); // 여기서 소미 정보가 조회되고 rs가 그 db정보를 가지고 있음 
			
			//while은 반복해서 정보를 가져올때, if는 정보를 한번만 가져올때 씀 
			if(rs.next()) { //아이디, 비번 정확하게 작성하고 로그인 성공 후 loginservlet 이동
				String name = rs.getString("name"); //이소미라는 이름 가져올것 
				String id = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int admin = rs.getInt("admin");
				
				mVo = new MemberVO();
				mVo.setName(name);
				mVo.setUserid(id);
				mVo.setPwd(pwd);
				mVo.setEmail(email);
				mVo.setPhone(phone);
				mVo.setAdmin(admin);
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
		
		return mVo;
	}
	//db에 가서 아이디가 있는지 없는지 확인하기
	public int confirmID(String userid) {
		int result = 1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//이렇게 쓰고 실행전에 오라클(또는 디비버)에 들어가서 써보면 있는지 없는지 확인 가능함(?자리에 somi쓰면 있으니까 결과에 somi가 나옴)
		String sql = "select userid from member where userid = ?";
		
		try {//다 비슷한 코드인데 여기서 달라지는거임 (150번~159번까지의 내용)
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery(); //select구문은 이걸로 날려주면 됨 
			
			if(rs.next()) {
				result = 1; //아이디 존재 => 사용불가 아이디(이미 쓰고 있는 아이디니까)
			}else {
				result = -1; //사용가능 아이디
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
		return result;
	}

	//join.jsp에서 정보 입력 다하고 확인 누르면 
	//회원정보 저장 -> 저장 성공하면 1, 실패하면 0만 넘어오니까 rs구문은 필요없음 
	public int insertMember(MemberVO mVo) {
		
		int result = 1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		try {
			//1.DB연결
			conn = getConnection();
			//2.sql구문 전송
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getPwd());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getPhone());
			pstmt.setInt(6, mVo.getAdmin());
			
			/*3. sql 구문 실행 
				executeUpdate -> insert, update, delete시 사용
				result : 0 -> 저장 실패
				result : 1 -> 저장 성공 
				commit은 auto commit; -> 자동으로 commit이 됨
			*/
			
			result = pstmt.executeUpdate(); //정보를 업데이트 시켜줘야하니까 ->이 문장으로 DB 자체에 저장이 되는것 
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		return result; // 0아니면 1이 리턴될거야 
	}
	//회원정보수정 
	public void updateMember(MemberVO mVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
										//1		2		3		4		 5		 6
		String sql = "update member set name=?, pwd=?, email=?, phone=?, admin=? where userid=?";
		
		try {
			//1.DB연결
			conn = getConnection();
			//2.sql구문 전송
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getPwd());
			pstmt.setString(3, mVo.getEmail());
			pstmt.setString(4, mVo.getPhone());
			pstmt.setInt(5, mVo.getAdmin());
			pstmt.setString(6, mVo.getUserid());
			
			/*3. sql 구문 실행 
				executeUpdate -> insert, update, delete시 사용
				result : 0 -> 저장 실패
				result : 1 -> 저장 성공 
				commit은 auto commit; -> 자동으로 commit이 됨
			*/
			
			pstmt.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
		}
	}
		
	}
}
