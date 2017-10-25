<%@page import="vo.FreeBoardArticle"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>�� �б� ȭ��</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<table border="1">
		<tr>
			<td>�۹�ȣ:</td>
			<td>${freeboardarticle.articleNum }</td>
		</tr>
		<tr>
			<td>����:</td>
			<td>${freeboardarticle.title}</td>
		</tr>
		<tr>
			<td>�ۼ���:</td>
			<td>${freeboardarticle.writer }</td>
		</tr>
		<tr>
			<td>�ۼ���:</td>
			<td>${freeboardarticle.writeTime }</td>
		</tr>
		<tr>
			<td>��ȸ��:</td>
			<td>${freeboardarticle.readCount}</td>
		</tr>
		<tr>
			<td>����:</td>
			<td>${freeboardarticle.contents}</td>
		</tr>
	</table>
	<a href=
		"${myContextPath}/board?type=answerForm&articleNum=${freeboardarticle.articleNum}">
		[�亯�ޱ�]
	</a>
	<c:if test="${sessionScope.loginId==freeboardarticle.id}">
		<a href=
		"${myContextPath}/board?type=updateForm&articleNum=${freeboardarticle.articleNum}">
			[�����ϱ�]
		</a>
		<a href=
		"${myContextPath}/board?type=deleteForm&articleNum=${freeboardarticle.articleNum}">
			[�����ϱ�]
		</a>
	</c:if>
	
	<a href=
	"${myContextPath}/freeboard?type=freeboardList">
		[�Խ��� �������]
	</a>
</body>
</html>





