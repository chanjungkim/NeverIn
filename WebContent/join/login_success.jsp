<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>로그인 완료 페이지</title>
</head>
<body>
<%
		response.sendRedirect(request.getContextPath()+"/board?type=boardList");
	%>
</body>
</html>