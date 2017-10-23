<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>로그인 완료 페이지</title>
</head>
<body>
	<h2>${sessionScope.loginId}님 반갑습니다!!</h2>
	<a href="${pageContext.request.contextPath}/board">
		게시판 입장하기
	</a>
</body>
</html>