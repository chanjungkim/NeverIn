<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>index페이지</title>
</head>
<body>
	<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<h2>지식인? 홈페이지에 오신것을 환영합니다.</h2>
	<a href="${myContextPath}/member?type=joinForm">회원가입</a>
	<a href="${myContextPath}/member?type=loginForm">로그인</a>
	<button onclick="<%request.getSession().invalidate();%>">세션날리기</button>
</body>
</html>

