<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>�α��� ����</title>
</head>
<body>
alert();
<%
	
		response.sendRedirect(request.getContextPath()+"/member?task=login");
	%>
</body>
</html>