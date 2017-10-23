<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>수정하기 완료</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

	<%
		int articleNum = 
			(Integer) request.getAttribute("articleNum");
	%>
	<h2>수정하기가 완료되었습니다.</h2>
	<a href=
		"<%=request.getContextPath()%>/board?type=boardList">
		[게시판 목록으로]
	</a>
	<a href=
		"<%=request.getContextPath()%>/board?type=read&articleNum=<%=articleNum%>">
		[수정한 글 보기]
	</a>
</body>
</html>




