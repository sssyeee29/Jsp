<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		if(window.name == "update"){
			window.opener.parent.location.href=
				"BoardServlet?command=board_update_form&num=<%= request.getParameter("num")%>"
		}else if(window.name == "delete"){
			alert("삭제되었습니다.");
			window.opener.parent.location.href=
				"BoardServlet?command=board_delete&num=<%= request.getParameter("num")%>"
		}
		window.close(); //창이 닫히면서 경로가 바뀜 -> 부모창이 17번줄에 있는 BoardServlet~~ 여기로 이동하라는거 
	</script>
</body>
</html>