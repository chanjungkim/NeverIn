<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<html>
<head>
<title>ȸ������ �Ϸ�</title>
</head>
<body>
<c:set var="myContextPath" 
			value="${pageContext.request.contextPath}"/>
	<h2>ȸ�������� �Ϸ�Ǿ����ϴ�.</h2>
	<a href="${myContextPath}/member?type=loginForm">
		�α����Ϸ� ����
	</a>
</body>
</html>