<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>���� ���</title>
</head>
<body>
<%
	Integer articleNum = (Integer) request.getAttribute("articleNum");
	response.sendRedirect(request.getContextPath()+"/board?type=read&articleNum="+articleNum);
%>
</body>
</html>