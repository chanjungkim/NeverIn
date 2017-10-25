<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>답변 성공</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>    
	<h2>답변 작업 성공하였습니다.</h2>
	<a href=
		"${myContextPath}/freeboard?type=freeboardList">
		[게시판 목록으로]
	</a>
</body>
</html>