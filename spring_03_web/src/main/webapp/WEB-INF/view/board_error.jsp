<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>
</head>
<body>
<% response.setStatus(200); %>
<h3>권한이 없습니다.</h3> &nbsp;
<h4>게시글의 작성자가 맞는지 확인해주세요.</h4>
<br>
</body>
</html>