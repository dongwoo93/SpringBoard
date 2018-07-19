<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	if(${result} > 0) {
		alert("탈퇴가 완료되었습니다");
		location.href = "index.jsp";
	}else {
		alert("탈퇴에 실패하였습니다");
		location.href = "index.jsp";
	}
	</script>
</body>
</html>