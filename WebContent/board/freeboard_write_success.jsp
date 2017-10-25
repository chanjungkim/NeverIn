<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>글쓰기 완료</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<h2>글쓰기 작업이 완료되었습니다.</h2>
	<a href=
		"${myContextPath}/freeboard?type=freeboardList">
		[게시판 목록으로]
	</a>
</body>
</html>