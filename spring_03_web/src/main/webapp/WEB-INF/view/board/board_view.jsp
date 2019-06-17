<%@page contentType="text/html; charset=utf-8" isELIgnored="false"%>
 
 
<html>
<head>
<title>게시글 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script >
	function boardList() {
		f.action="list.do"
		f.submit();
	}
	function boardModify() {
		f.action="modify.do";
		f.submit();
	}
	function boardRemove() {
		if ( confirm("정말 삭제하시겠습니까?") ) {
			f.action="remove.do";
			f.submit();
		}
	}
</script>
</head>
<body >
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	`  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>게시글 관리 - 글 수정</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <!-- view Form  -->
	  <form name="f" method="post" action="">
	  <input type="hidden" name="seq" value="${board.seq}">
	  <table border="0" cellpadding="0" cellspacing="1" width="610" bgcolor="BBBBBB">
	  	  <tr>
			<td width=120 align=center bgcolor="E6ECDE" height="22">게시글 번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 ${board.seq}
			</td>
		  </tr>
		  <tr>
			<td width=120 align=center bgcolor="E6ECDE" height="22">게시글 제목</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 ${board.title}
			</td>
		  </tr>
		  <tr>
			<td width=120 align=center bgcolor="E6ECDE" height="22">게시글 내용</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 				 ${board.content}
			</td>
		  </tr>
		  <tr>
			<td width=120 align=center bgcolor="E6ECDE" height="22">게시글 작성날짜</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 				 ${board.regdate}
			</td>
		  </tr>		
		  <tr>
			<td width=120 align=center bgcolor="E6ECDE" height="22">게시글 조회수</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 				 ${board.cnt}
			</td>
		  </tr>		
		  <tr>
			<td width=120 align=center bgcolor="E6ECDE" height="22">게시글 작성자</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 				 ${board.id}
			</td>
		  </tr>		
	  </table>
	  </form>
	  <table width=610 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="button" value="수정" onClick="boardModify()"> &nbsp;
			<input type="button" value="삭제" onClick="boardRemove()"> &nbsp;
			<input type="button" value="목록" onClick="boardList()"> 
			</td>
		  </tr>
	  </table>
	  </td>
	</tr>
</table>  

</body>
</html>