package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpadateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//boardUpdate에서 작성한 수정할 내용들을 가져오는것임
		String num = request.getParameter("num");	// number가 넘어와야지 몇번 게시글을 수정하는지 알 수 있음
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		BoardVO bVo = new BoardVO();
		bVo.setNum(Integer.parseInt(num));
		bVo.setName(name);
		bVo.setPass(pass);
		bVo.setEmail(email);
		bVo.setTitle(title);
		bVo.setContent(content);
		
//		BoardDAO bDao = BoardDAO.getInstance();
//		bDao.updateBoard(bVo);
		
		BoardDAO.getInstance().updateBoard(bVo); // 32번, 33번을 체인기법을 써서 한줄로 쓴 것 
		
		//리스트 목록 이동 -> update가 끝나면 전체 리스트 목록으로 돌아갈거임
		new BoardListAction().execute(request, response);
		
	}

}
