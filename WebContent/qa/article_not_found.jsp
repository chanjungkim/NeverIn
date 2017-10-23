<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>글번호 오류 화면</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

	<h2>게시글을 찾을 수 없습니다. 다시 시도해주세요.</h2>
	<a href="<%=request.getContextPath()%>/board?type=boardList">
		홈으로
	</a>

</body>
</html>