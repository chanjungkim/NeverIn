<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>���� ���</title>
<script>
	$(function(){
		alert('���� ����');	
	})
</script>
</head>
<body>
<%
	String articleNum = (String) request.getAttribute("articleNum");
	response.sendRedirect(request.getContextPath()+"/board?type=read&articleNum="+articleNum);
%>
</body>
</html>