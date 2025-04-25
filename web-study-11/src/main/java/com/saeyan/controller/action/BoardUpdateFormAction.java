package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVO = bDao.selectOneBoardByNum(Integer.parseInt(num));
		
		request.setAttribute("board", bVO);
		
		//여기있는거 꺼내서 화면에 출력해주기 
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
		
	}

}
