<%@page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script language="JavaScript">
function boardModify() {
	f.action= "update.do";
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
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>게시글 관리 - 게시글 수정</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <!-- modify Form  -->
	  <form name="f" method="post" action="">
	 	   <input type="hidden" name="seq" value="${board.seq}">
	 	   <input type="hidden" name="id" value="${board.id}"> 
	 
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">게시글 번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				${board.seq}
			</td>
		  </tr>
		 
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">게시글 제목</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="title" value="${board.title}">
			</td>
		  </tr>	
		 <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">게시글 내용</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="content" value="${board.content}">
			</td>
		  </tr>	
		  
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">게시글 작성날짜</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				${board.regdate}
			</td>
		  </tr>
		  
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">게시글 조회수</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				${board.cnt}
			</td>
		  </tr>
		  
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">게시글 작성자</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				${board.id}
			</td>
		  </tr>
		  
	  </table>
	  </form>
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="button" value="수정" onClick="boardModify()"> &nbsp;
			<input type="button" value="목록" onClick="boardList()">
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  

</body>
</html>