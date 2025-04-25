package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;
//글 제목 누르면 상세페이지 나오는 화면 구현
public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//boardServlet에서 전달받은값을 그대로 출력하는거라서 sysout하면 콘솔에 코드값이 출력됨 
		int num = Integer.parseInt(request.getParameter("num"));

		BoardDAO bDao = BoardDAO.getInstance();
		
		//조회수 증가 
		bDao.updateReadCount(num);
		
		//num(primary key)에 해당하는 데이터 가져오기 - 값을 하나씩 가져올때 bVo에 담아서 가져오라는
		BoardVO bVo = bDao.selectOneBoardByNum(num); //여기에 있는 bVo는 BoardDAO에 있는 단 건 데이터 가져오기 부분 if절을 가지고 있음 
		request.setAttribute("board", bVo); //new BoardVO의 값을 "board"가 가지고 있는것 
		
		request.getRequestDispatcher("/board/boardView.jsp").forward(request, response);
	}

}
