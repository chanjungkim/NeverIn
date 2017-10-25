<%@page import="vo.FreeBoardArticle"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>�� ����</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>

<form action="${myContextPath}/freeboard" method="post">
	<input type="hidden" name="articleNum" value="${freeboardarticle.articleNum }">
	<input type="hidden" name="type" value="update">
	<table border="1">
		<tr>
			<td>�۹�ȣ:</td>
			<td>${freeboardarticle.articleNum }</td>
		</tr>
		<tr>
			<td>����:</td>
			<td>
				<input type="text" name="title" value="${freeboardarticle.title}">
			</td>
		</tr>
		<tr>
			<td>�ۼ���:</td>
			<td>${freeboardarticle.writer}</td>
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
			<td>
				<input type="text" name="contents" value="${freeboardarticle.contents}">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="���� �Ϸ�">
			</td>
		</tr>
	</table>
</form>
</body>
</html>





