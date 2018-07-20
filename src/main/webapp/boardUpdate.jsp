<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>

	table {
		border: 1px solid;	
		width: 500px;
		height: 500px;
		margin: 0px auto;
		margin-top: 50px;
	}
	
	th, td {
		border: 1px solid;
	}
	
	div {
		width: 500px;
		margin: 0px auto;
		text-align: right;
	}

</style>

</head>
<body>
	<form action="boardUpdateProc.do" method="post">
	<input type="hidden" name="seq" value="${seq}">
	<table>
	
	<tr>
		<th height="10%">제목</th>
		<td><input type="text" placeholder="제목을 입력하세요" style="width: 99%" name="title"></td>
	</tr>
	
	<tr>
		<th height="90%" width="80px">내용</th>	
		<td><textarea placeholder="내용을 입력하세요" 
		cols="58" rows="30" style="resize: none;" name="contents"></textarea></td>
	</tr>
	
	</table> 

	<div>
		<input type="button" value="목록으로">
		<button>수정하기</button>
	</div>
	</form>
</body></html>