package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;


@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("member/join.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//join.jsp에서 확인 누르면 doPost가 실행해서 여기로 오는거(정보전달이니까 doPost)
		//이렇게 해야지 저장된 DB에서 조회할 때 oracle에서 한글이 안깨짐 
		request.setCharacterEncoding("utf-8");
		
		//join.jsp에서 넘어오는 정보들을 담아줘야함 	
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		//요청 온 6가지정보를 박스로 포장하는 단계 
		MemberVO mVo = new MemberVO();
		mVo.setName(name);
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAdmin(Integer.parseInt(admin));
		
		//1. DB연결 
		MemberDAO mDao = MemberDAO.getInstance();
		
		//2. DB에 저장할 메소드 호출 -> 이클립스가 MemberDAO에 자동으로 메소드생성해줌 
		int result = mDao.insertMember(mVo); // 저장성공하면 1, 실패하면 0

		HttpSession session = request.getSession();
		
		if(result==1) {
			session.setAttribute("userid", mVo.getUserid());
			request.setAttribute("message", "회원가입에 성공했습니다.");
		}else {
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
	
	}

}
