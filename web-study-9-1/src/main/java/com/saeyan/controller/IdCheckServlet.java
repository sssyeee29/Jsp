package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;


@WebServlet("/idCheck.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 	String userid = request.getParameter("userid");
	 	
	 	MemberDAO mDao = MemberDAO.getInstance();
	 	
	 	int result = mDao.confirmID(userid); //아이디가 중복되면 1, 아니면 -1
	 	//request.setAttribute()는 forward()로 이동한 JSP에서만 유효함
	 	request.setAttribute("userid", userid); //jsp파일에 그 값을 넘겨주기 위해서!! 이렇게 저장해두면 login.jsp에서 get으로 다시 보여줄 수 있음
	 	request.setAttribute("result", result);
	 	
	 	request.getRequestDispatcher("member/idCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
