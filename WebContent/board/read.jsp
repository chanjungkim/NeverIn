<%@page import="vo.FreeBoardArticle"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>글 읽기 화면</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<table border="1">
		<tr>
			<td>글번호:</td>
			<td>${freeboardarticle.articleNum }</td>
		</tr>
		<tr>
			<td>제목:</td>
			<td>${freeboardarticle.title}</td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td>${freeboardarticle.writer }</td>
		</tr>
		<tr>
			<td>작성일:</td>
			<td>${freeboardarticle.writeTime }</td>
		</tr>
		<tr>
			<td>조회수:</td>
			<td>${freeboardarticle.readCount}</td>
		</tr>
		<tr>
			<td>내용:</td>
			<td>${freeboardarticle.contents}</td>
		</tr>
	</table>
	<a href=
		"${myContextPath}/board?type=answerForm&articleNum=${freeboardarticle.articleNum}">
		[답변달기]
	</a>
	<c:if test="${sessionScope.loginId==freeboardarticle.id}">
		<a href=
		"${myContextPath}/board?type=updateForm&articleNum=${freeboardarticle.articleNum}">
			[수정하기]
		</a>
		<a href=
		"${myContextPath}/board?type=deleteForm&articleNum=${freeboardarticle.articleNum}">
			[삭제하기]
		</a>
	</c:if>
	
	<a href=
	"${myContextPath}/freeboard?type=freeboardList">
		[게시판 목록으로]
	</a>
</body>
</html>





