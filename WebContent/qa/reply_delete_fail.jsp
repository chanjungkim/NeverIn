<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>수정 결과</title>
<script>
	$(function(){
		alert('삭제 실패');	
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