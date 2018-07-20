<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<style>

	table {
		border: 1px solid;	
		width: 600px;
		height: 600px;
		margin: 0px auto;
		margin-top: 50px;
	}
	
	th, td {
		border: 1px solid;
	}
	
	div {
		margin: 0px auto;
		width: 600px;
		text-align: right;
	}

</style>

</head>
<body>

	<table>
	
		<tr height="10%">
		
		<td>작성자 ${result.writer}</td>
		<td>작성일 ${result.writedate}</td>
		
		</tr>
	
		<tr height="10%">
		<td colspan="2">제목 ${result.title}</td>
		</tr>
	
		<tr height="80%">
		<td colspan="2">${result.contents}</td>
		</tr>
	
	</table>

	<div>
		<c:choose>
		
		<c:when test="${sessionScope.loginId}">
			<input type="button" value="수정하기">
			<input type="button" value="삭제하기">
			<input type="button" value="목록으로">
		</c:when>
		
		
		<c:otherwise>
		<input type="button" value="수정하기">
		<input type="button" value="삭제하기">
		<input type="button" value="목록으로">
		</c:otherwise>
		
		</c:choose>
	</div>

</body>
</html>