<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>���� ����</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>    
	<h2>���� �۾� �����Ͽ����ϴ�.</h2>
	<a href=
		"${myContextPath}/freeboard?type=freeboardList">
		[�Խ��� �������]
	</a>
</body>
</html>