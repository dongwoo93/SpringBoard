<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<style>

	table {
		border: 1px solid;	
		width: 1000px;
		margin: 0px auto;
		margin-top: 150px;
	}
	
	th, td {
		border: 1px solid;
	}

	#bt {
		text-align: right;
		margin: 0px auto;
		width: 1000px;
	}
	
	
	
</style>

</head>
<body>

	<table>
		
	<tr>
		<th style="width: 10%">번호</th>
		<th style="width: 50%">제목</th>	
		<th style="width: 20%">작성자</th>
		<th style="width: 10%">작성일</th>
		<th style="width: 10%">조회수</th>
	</tr>
		
	<c:forEach var="item" items="${result}">
	<tr>
		<td>${item.seq} </td>
		<td><a href="boardView.do?seq=${item.seq}">${item.title}</a></td>
		<td>${item.writer}</td>
		<td>${item.writedate}</td>
		<td>${item.viewcount}</td>
	</tr>	
	</c:forEach>
	
	
	</table>

	<div id="bt">
	<input type="button" id="writing" value="글쓰기" onclick="location.href='boardWriting.do?id=${sessionScope.loginId}'">
	</div>
</body>
</html>