package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCheckPassFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//boardview에있는 내용 담아서 간다는 뜻 
		request.getRequestDispatcher("/board/boardCheckPass.jsp").forward(request, response);
		
	}

}
