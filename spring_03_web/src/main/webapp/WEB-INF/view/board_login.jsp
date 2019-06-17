<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h2>로그인 폼</h2>
	<form id="form1" name="form1" action="board_login.do" method="post" >
		<table border="1">
			<tr>
				<td colspan="2">${msg}</td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="userid"
				required="required"></td>
				<!-- required를 사용하여 유효성 검증 -->
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" id="pw" name="userpwd"
				pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{4,7})"
				required="required"></td>
				<!-- required를 사용하여 유효성 검증 -->
				<!-- pattern	(?=.*\d)숫자 0회 이상반복,
								(?=.*[a-z])소문자 0회 이상반복,
								(?=.*[A-Z])대문자 0회 이상반복,
								(?=.*[^a-zA-Z0-9])특수문자 0회 이상반복,
								.{4,7}길이가 4개에서 7개 사이를 만족해야 한다.	-->
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="reset" value="취소">
				</td>
			</tr>
			<td colspan="2">
				<a href="#"> 회원가입</a>
			</td>
		</table>
	</form>
</body>
</html>