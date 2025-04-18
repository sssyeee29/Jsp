package com.saeyan.controller;

import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;




@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
		
			MemberVO mVo = (MemberVO)session.getAttribute("loginUser");
			
			MemberDAO mDao = MemberDAO.getInstance();
			mVo = mDao.getMember(mVo.getUserid());
			
			session.setAttribute("loginUser", mVo);
			url = "main.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		String url = "member/login.jsp";
		
		//DB연결해서 userid, pwd가 해당하는게 있는지 확인!(memberdao파일에 db연결하는게 있어서)
		MemberDAO mDao = MemberDAO.getInstance(); // MemberDAO 17,18번째 줄을 통해서 이렇게 쓸 수 있는 것 
		
		//사용자가 입력한 아이디와 비번이 DB에 실제로 존재하는지 확인하는 부분
		//mDao는 MemberDAO 클래스의 인스턴스, DAO는 DB와 연결되어있음 -> DB에 저장된 아이디/비번과 비교해서 로그인 가능한 상태인지 판단해줌
		int result = mDao.userCheck(userid,pwd); //아이디, 비번 작성 후 여기로 오는거(DB에서 검증->memberDAO에서 34번째 줄)
		/*
		switch(result) {
		 case 1 :
			 System.out.println("로그인 여부 : 성공");
			 break;
		 case 0 :
			 System.out.println("로그인 여부 : 비번 틀림");
			 break;
		 case -1 :
			 System.out.println("로그인 여부 : 아이디 틀림");
			 break;
		}
		System.out.println("로그인 여부 : " + result );
		*/
		
		if(result == 1) {

			MemberVO mVo =  mDao.getMember(userid); //db에 있는 정보를 mVo에 넣어야함 insert했던 정보들 
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			url = "main.jsp";
			System.out.println("================================");
			
		}else if(result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response); //36번 url에 post 해서 이동 login.jsp엔 post가 없지만 안에 내장되어있음
	}

}
