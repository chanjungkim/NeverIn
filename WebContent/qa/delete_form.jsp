<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>삭제 확인 페이지</title>
</head>
<body>	
<jsp:include page="../menu.jsp"/>

<%
	int articleNum = 
		(Integer) request.getAttribute("articleNum");
%>
	<form action="<%=request.getContextPath()%>/board" 
											method="post">

 
		<input type="submit" value="삭제확인">
		<input type="hidden" name="type" value="delete">
		<input type="hidden" name="articleNum" 
								value="<%=articleNum%>">
	</form>
</body>
</html>