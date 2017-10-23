<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<html>
<head>
<title>회원가입 완료</title>
</head>
<body>
<c:set var="myContextPath" 
			value="${pageContext.request.contextPath}"/>
	<h2>회원가입이 완료되었습니다.</h2>
	<a href="${myContextPath}/member?task=loginForm">
		로그인하러 가기
	</a>
</body>
</html>