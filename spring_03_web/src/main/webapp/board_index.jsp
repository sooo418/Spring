<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/board_login.do">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/board/list.do">board 목록</a></li>
		<li><a href="${pageContext.request.contextPath}/board_logout.do">로그아웃</a></li>
	</ul>
</body>
</html>