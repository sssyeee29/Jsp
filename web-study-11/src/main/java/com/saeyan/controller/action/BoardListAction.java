package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//boardList에 있는거 꺼내서 계속 값을찍어주면됨, jsp가 view가 되는거 
		String url = "/board/boardList.jsp";
		
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardVO> boardList = bDao.selectAllBoards();
		
		// forward 이용해서 boardList.jsp로 이동, model은 boardList에 담겨있음 
		// request 객체에 model이 담기고, view는 jsp파일이고 이 두개가 requestDispatcher.forward()를 
		// 통해 하나로 합쳐져서 브라우저(jsp)에 보여짐 
		request.setAttribute("boardList", boardList); // model을 담아 
		request.getRequestDispatcher(url).forward(request, response);
	}

}
