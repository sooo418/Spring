<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="./css/table.css">

<h3 style="text-align: center">userinfo List</h3>

<table>
	<tr>
	<th>userid</th><th>username</th><th>email</th>
	<th>phone</th><th>address</th>
	</tr>
<c:forEach var="user" items="${users}">
	<tr>
		<td>${user.userid}</td>
		<td>${user.username}</td>
		<td>${user.email}</td>
		<td>${user.phone}</td>
		<td>${user.address}</td>
	</tr>
</c:forEach>
</table>