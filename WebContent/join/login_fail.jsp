<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>로그인 실패</title>
</head>
<body>
	로그인에 실패하였습니다. 아이디와 패스워드를 다시 확인해주세요.
	<hr>
	<a href="${pageContext.request.contextPath}/member?task=loginForm">
		로그인 하러 가기
	</a>
</body>
</html>