<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>삭제하기 완료</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

<%
		response.sendRedirect(request.getContextPath()+"/board?type=boardList");
%>
</body>
</html>