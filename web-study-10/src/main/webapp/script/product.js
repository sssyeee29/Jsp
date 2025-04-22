function productCheck() {
   if (document.frm.name.value.length == 0) {
      alert("상품명을 써주세요.");
      frm.name.focus();
      return false;
   }
   if (document.frm.price.value.length == 0) {
      alert("가격을 써주세요");
      frm.price.focus();
      return false;
   }
   if (isNaN(document.frm.price.value)) {
      alert("숫자를 입력해야 합니다");
      frm.price.focus();
      return false;
   }
   return true;
}

function chkDelete() {
	alert("삭제창");
	
	if (confirm("정말 삭제하시겠습니까?")) {
        return true;  // 확인 -> 삭제 진행
    } else {
        return false; // 취소 -> 삭제 중단
    }
}