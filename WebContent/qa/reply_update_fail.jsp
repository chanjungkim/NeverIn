<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>수정 결과</title>
</head>
<script>
	$(function(){
		alert('업데이트 실패');	
	})
</script>
<body>
<%
	Integer articleNum = (Integer) request.getAttribute("articleNum");
	response.sendRedirect(request.getContextPath()+"/board?type=read&articleNum="+articleNum);
%>
</body>
</html>