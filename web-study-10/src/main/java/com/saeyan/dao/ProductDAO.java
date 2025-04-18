package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {
	}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	//DB에서 전체 목록 가져오기 ->select * from ~~~>
	public List<ProductVO> selectAllProducts(){
		String sql = "select * from product order by code desc"; //desc는 내림차순 
	
		List<ProductVO> list = new ArrayList<ProductVO>(); // 배열처럼 주석값을 계속 추가할 수 있음 -> productVO거나 상속받은애들 다 쓸 수 있음(제네릭방법) 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. DB연결
			conn = DBManager.getConnection();
			//2. sql 구문 전송
			pstmt = conn.prepareStatement(sql);
			
			//3. sql 맵핑 -> 지금 여기엔 맵핑이 없음 // 맵핑은 25번째줄 코드 맨끝에 ?가 있는거를 말하는데 여기엔 없음 
			
			//4. sql 실행
			rs = pstmt.executeQuery(); //select니까 executeQuery쓰기 
			
			//여러건 가지고 오기위해서 while씀 -> product 테이블에 5가지 가져오기
			//삽입시킨 목록의 내용 순서대로 불러오기
			while(rs.next()) {
				//5가지 값을 mVo에 담아서 가져오기위함 
				ProductVO mVo = new ProductVO();
				
				//순서대로 담아주고 
				mVo.setCode(rs.getInt("code"));
				mVo.setName(rs.getString("name"));
				mVo.setPrice(rs.getInt("price"));
				mVo.setPictureurl(rs.getString("pictureurl"));
				mVo.setDescripition(rs.getString("description"));
				
//				rs.getInt("code");
//				rs.getString("name");
//				rs.getInt("price");
//				rs.getString("pictureurl");
//				rs.getString("description");
				
				list.add(mVo); //5번 반복함
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs); //매번 쓰기 귀찮아서 dbmanger에 3개 받아주는 코드로 한번에 처리하기 
		}	
		return list;
	}
}
