<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
		$("#back").click(function(){
			$(location).attr("href", "index.do");
		})
	})
</script>
</head>
<body>
	<table border='1' align="center">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>우편번호</td>
			<td>주소1</td>
			<td>주소2</td>
		</tr>
		<tr>
			<td>${list.id}</td>
			<td>${list.name}</td>
			<td>${list.phone1}- ${list.phone2} - ${list.phone3}</td>
			<td>${list.email}</td>
			<td>${list.zipcode}</td>
			<td>${list.address1}</td>
			<td>${list.address2}</td>
		</tr>

		<tr>
			<td colspan=7 align="right"><button type="button" id="back">뒤로가기</button></td>
		</tr>
	</table>
</body>
</html>