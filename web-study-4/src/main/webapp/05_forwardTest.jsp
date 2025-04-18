<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

int age = Integer.parseInt(request.getParameter("age")); // String타입인데 숫자 입력 받아야하니까 integer해줌

if(age<=19){
%>
	<script type="text/javascript">
		alert("19세 미만이므로 입장 불가능")
		history.go(-1) // 전 단계로 넘어감 - 19세 미만이면 이 페이지가 다시 나옴 
	</script>
<%
}else{
	request.setAttribute("name", "성윤정"); //직접 추가할때는 setAttribute로 써야함 // setparameter로 하면 안됨(아예 새로 추가하니까)
	RequestDispatcher dis = request.getRequestDispatcher("05_forwardResult.jsp");
	dis.forward(request, response);
}

%>