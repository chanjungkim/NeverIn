<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<!-- �������� �ּ�ȭ�� �ֽ� CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- �ΰ����� �׸� -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- �������� �ּ�ȭ�� �ֽ� �ڹٽ�ũ��Ʈ -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>�� �ۼ� ȭ��</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
<div class="container">    
	<form action="${myContextPath}/freeboard" method="post">
		<input type="hidden" name="type" value="write">	
		<input type="hidden" name="id" value="${sessionScope.loginId}">											
		<table class="table table-bordered">
			<tr>
				<td>����:</td>
				<td>
					<input type="text" name="title" size="10">
				</td>
			</tr>
			<tr>
				<td>����:</td>
				<td>
					<textarea rows="5" cols="10" name="contents" placeholder="���⿡ ������ �Է��ϼ���."></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="�ۼ��Ϸ�">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>