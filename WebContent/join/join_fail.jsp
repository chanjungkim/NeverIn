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
<script type="text/javascript">
	window.onload = function(){
		alert('회원가입이 실패하였습니다.');
		location.href='${myContextPath}'+"/member?task=index";
	}
</script>
</body>
</html>