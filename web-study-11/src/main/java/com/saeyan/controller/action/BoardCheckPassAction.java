package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override 
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//action = new BoardCheckPassAction 여기에 num랑 pass랑 board_check_pass 이렇게 세개가 전달됨->주석값이 action에 전달되니까 
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		String url = null;
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		//숫자를 넘겨주니까 string이였던 num을 형변환시킴
		BoardVO bVo = bDao.selectOneBoardByNum(Integer.parseInt(num));
		
		//입력한 비번과 db에 있는 비번  비교
		if(bVo.getPass().equals(pass)) {
			url = "/board/checkSuccess.jsp";
		}else {
			url = "board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
