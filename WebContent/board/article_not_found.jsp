<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>�۹�ȣ ���� ȭ��</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
	<h2>�Խñ��� ã�� �� �����ϴ�. �ٽ� �õ����ּ���.</h2>
	<a href="${myContextPath}/board?task=boardList">
		�������
	</a>

</body>
</html>