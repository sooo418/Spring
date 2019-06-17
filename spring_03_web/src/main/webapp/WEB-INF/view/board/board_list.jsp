<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/table2.css">
<meta charset="UTF-8">
<title>Board List (게시판 관리)</title>
</head>
<body>
<h3>board 검색</h3>
<form action="${pageContext.request.contextPath}/board/search.do" method="post">
<table id="select" border="0">
	<tr>
		<td><select name="searchCondition">
				<option value="title"> 제목 </option>
				<option value="content"> 내용 </option>
				<option value="id"> 아이디 </option>
			</select>
			<input type="text" name="searchKeyword">
			<input type="submit" value="검색"/>
		</td>
	</tr>
</table>
</form>

	<h3>게시판</h3>
<form name="f" method="get" action="${pageContext.request.contextPath}/board/add.do">
	<table border="1">
		<tr>
		<th>seq</th><th>title</th>
		<th>content</th><th>regdate</th>
		<th>cnt</th><th>userid</th>
		</tr>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td>${board.seq}</td>
				<td><a href="${pageContext.request.contextPath}/board/view.do?seq=${board.seq}">
				${board.title}</td>
				<td>${board.content}</td>
				<td>${board.regdate}</td>
				<td>${board.cnt}</td>
				<td>${board.id}</td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<tr><td><input type="submit" value="게시글 추가"/></td></tr>
	</table>
	</form>
</body>
</html>