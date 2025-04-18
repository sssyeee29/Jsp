function loginCheck(){
	
	if(document.frm.userid.value.length == 0){
		alert("아이디 입력해 주세요");
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value == ""){
		alert("아이디 입력해 주세요");
		frm.pwd.focus();
		return false;
	}
		
	return true; //유효성 검사 통과 시 (로그인) 폼 전송
}

function idCheck(){
	alert("idCheck");
	
	if(document.frm.userid.value == ""){
		alert("아이디를 입력해 주세요");
		document.frm.userid.focus();
		return false;
	}
	
	let url = "idCheck.do?userid=" + document.frm.userid.value; //팝업창 열림 
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");//이건 열린 팝업창의 속성
}

function idok(){
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value; //hidden의 reid에도 값을 넣어줘라
	self.close();
}

function joinCheck(){
	if(document.frm.name.value.length == 0){
		alert("이름을 써주세요");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.userid.value.length==0){
		alert("아이디를 써주세요");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.userid.value.length < 4){
		alert("아이디는 4글자 이상이어야 합니다.");
		frm.name.focus();
		return false;
	}
		
	if(document.frm.pwd.value == ""){
		alert("암호는 반드시 입력해야합니다.");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("암호가 일치하지 않습니다.");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.reid.value.length == 0){
		alert("중복체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	
	return true;
}