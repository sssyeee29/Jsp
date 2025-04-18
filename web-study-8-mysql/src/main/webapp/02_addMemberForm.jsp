<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 정보 입력</title>

  <!--jQuery CDN 추가 -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  <!--스타일 적용 -->
  <style>
    * { margin: 0; box-sizing: border-box; }

    body {
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      font-family: 'Arial', sans-serif;
      background: linear-gradient(to right, #a1c4fd, #c2e9fb);
    }

    .wrapper {
      background: white;
      padding: 40px;
      border-radius: 20px;
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
      width: 400px;
    }

    h2 {
      text-align: center;
      margin-bottom: 30px;
      color: #333;
    }

    table {
      width: 100%;
      border-spacing: 15px;
    }

    input[type="text"],
    input[type="password"],
    input[type="email"] {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 8px;
    }

    input[type="submit"],
    input[type="reset"] {
      padding: 10px 20px;
      border: none;
      border-radius: 8px;
      background-color: #6fb1fc;
      color: white;
      cursor: pointer;
    }

    input[type="submit"]:hover,
    input[type="reset"]:hover {
      background-color: #4a91f2;
    }

    td {
      vertical-align: middle;
    }
  </style>

  <!--유효성 검사 -->
  <script>
    $(document).ready(function () {
      $('form').on('submit', function (e) {
        const name = $('input[name="name"]').val().trim();
        const userid = $('input[name="userid"]').val().trim();
        const pwd = $('input[name="pwd"]').val().trim();
        const email = $('input[name="email"]').val().trim();
        const phone = $('input[name="phone"]').val().trim();

        if (name === '' || userid === '' || pwd === '' || email === '' || phone === '') {
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

    <form method="post" action="02_addMember.jsp">
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" name="name"></td>
        </tr>
        <tr>
          <td>아이디</td>
          <td><input type="text" name="userid"></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
          <td>이메일</td>
          <td><input type="email" name="email"></td>
        </tr>
        <tr>
          <td>전화번호</td>
          <td><input type="text" name="phone"></td>
        </tr>
        <tr>
          <td>등급</td>
          <td>
            <input type="radio" name="admin" value="1"> 관리자
            <input type="radio" name="admin" value="0" checked> 일반회원
          </td>
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
