package com.saeyan.controller.action;

public class ActionFactory {
	//싱글톤패턴 객체생성
	private static ActionFactory instance  = new ActionFactory();
	
	private ActionFactory() {
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
							//board_wirte_form => if절에 있는 ""내용들이 command로 전달되는거 
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("board_list")) { //넘어온게 board_list니?
			action = new BoardListAction(); //new 붙여서 객체 만들어서 action 참조, 반드시 action 인터페이스구현해야함 
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction(); //생성된 객체를 action에 담아서 boardServlet의 Action action이 받음 그래서 
												// BoardWriteFormAction에 가서 override 추가해줌 
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction(); //객체 생성후 BoardWriteAction에서 execute 메소드 추가????
		}else if(command.equals("board_view")) {
			action = new BoardViewAction();
		}else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		}else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction(); 
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction(); // 수정하려면 화면 자체가 먼저 보여야하니까 
		}else if(command.equals("board_update")) {
			action = new BoardUpadateAction();
		}
		
		return action;
	}
}
