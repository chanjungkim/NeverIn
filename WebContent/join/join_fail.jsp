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
<script type="text/javascript">
	window.onload = function(){
		alert('ȸ�������� �����Ͽ����ϴ�.');
		location.href='${myContextPath}'+"/member?task=index";
	}
</script>
</body>
</html>