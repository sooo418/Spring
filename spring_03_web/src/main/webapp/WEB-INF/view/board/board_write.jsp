<%@page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>사용자 관리</title>
<meta charset="utf-8">
<script language="JavaScript">
function boardCreate() {	
	f.action="./add.do";
	f.method="post";
	f.submit();
}

function boardList() {
	f.action = "list.do";
	f.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>게시글 작성</b></td>
		  </tr>
	  </table>  
	  <br>
	  <!-- view Form  -->
	  <form name="f" method="post" action="">
	  
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:150" name="title" >
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:150" name="content" >
			</td>
		  </tr>
		  
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">게시날짜</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="regdate" >
				
			</td>
		  </tr>
		  <tr>
		
	  </table>

	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="button" value="게시" onClick="boardCreate()"> &nbsp;
			<input type="button" value="목록" onClick="boardList()">
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  
	  </form>
</body>
</html>