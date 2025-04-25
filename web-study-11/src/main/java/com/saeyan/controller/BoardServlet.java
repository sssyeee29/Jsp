package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.ActionFactory;

//Spring --> dispatcherServlet(front controller)
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// BoardServlet?command=board_write_form
		String command = request.getParameter("command");
		System.out.println("BoardServlet에서 요청을 받음을 확인: " + command);
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command); //ActionFactioy에서 해당 if절꺼를 받는거 //list,write든 상관없이 일단 얘가 받아줘서 ActionFactory로 전달 
		
		//Handler Mapping
		if(action != null) {
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		doGet(request, response);
	}

}
