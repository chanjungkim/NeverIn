<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>삭제 실패</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>    
	<h2>삭제 작업 실패하였습니다.</h2>
	<a href=
		"${myContextPath}/freeboard?type=freeboardList">
		[게시판 목록으로]
	</a>
</body>
</html>