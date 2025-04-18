package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = "member.login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			
			EmployeesVO eVo = (EmployeesVO)session.getAttribute("loginUser");
			
			EmployeesDAO eDao = EmployeesDAO.getInstance();
			eVo = eDao.getMember(eVo.getId());
			
			session.setAttribute("loginUser", eVo);
			url = "main.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		}
					
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String pass =request.getParameter("pass");
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		EmployeesVO eVo = eDao.getMember(id);
		
		String url = "member/login.jsp";
		
		 if (eVo != null && eVo.getPass().equals(pass)) {
		        HttpSession session = request.getSession();
		        session.setAttribute("loginUser", eVo);
		        url = "main.jsp";
		    } else {
		        request.setAttribute("message", "아이디 또는 비밀번호가 틀렸습니다.");
		    }

		    request.getRequestDispatcher(url).forward(request, response);
		
		
		
	}

	
	
	
	
	
	
	
	
	
}
