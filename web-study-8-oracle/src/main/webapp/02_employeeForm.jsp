<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 정보 입력</title>

  <!--jQuery CDN 추가 -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  <!--유효성 검사 -->
  <script>
    $(document).ready(function () {
      $('form').on('submit', function (e) {
        const name = $('input[name="name"]').val().trim();
        const address = $('input[name="address"]').val().trim();
        const ssn = $('input[name="ssn"]').val().trim();


        if (name === '' || address === '' || ssn === '' ) {
          alert('모든 항목을 입력해주세요.');
          e.preventDefault(); // 제출 막기
        }
      });
    });
  </script>

</head>
<body>
  <div class="wrapper">
    <h2>회원 정보 입력</h2>

    <form method="post" action="02_employee.jsp">
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" name="name"></td>
        </tr>
        <tr>
          <td>주소</td>
          <td><input type="text" name="address"></td>
        </tr>
        <tr>
          <td>주민번호</td>
          <td><input type="password" name="ssn"></td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" value="전송">
            &nbsp;&nbsp;
            <input type="reset" value="취소">
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
