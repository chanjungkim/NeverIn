<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>글쓰기 완료</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<jsp:include page="../menu.jsp"/>

	<h2>글쓰기 작업이 완료되었습니다.</h2>
	<a href=
		"<%=request.getContextPath()%>/board?type=boardList">
		[게시판 목록으로]
	</a>
</body>
</html>