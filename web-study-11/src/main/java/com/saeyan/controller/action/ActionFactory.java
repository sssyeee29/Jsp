package com.saeyan.controller.action;

public class ActionFactory {
	//싱글톤패턴 
	private static ActionFactory instance  = new ActionFactory();
	
	private ActionFactory() {
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
							//board_wirte_form
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("board_list")) { //넘어온게 board_list니?
			action = new BoardListAction(); //new 붙여서 객체 만들어서 action 참조 
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction(); //생성된 객체를 action에 담아서 boardServlet의 Action action이 받음 그래서 
												// BoardWriteFormAction에 가서 override 추가해줌 
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction(); //객체 생성후 BoardWriteAction에서 execute 메소드 추가????
		}
		
		return action;
	}
}
