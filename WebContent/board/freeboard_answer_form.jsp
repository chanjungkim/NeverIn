<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>��� �ۼ� ȭ��</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>    
	<form action="${myContextPath}/freeboard" method="post">
		<input type="hidden" name="type" value="answer">	
		���̵�<input type="text" name="id" value="${sessionScope.loginId}"><br>
		�����۹�ȣ<input type="text" name="articleNum" value="${freeboardarticle.articleNum}"><br>
		<table border="1">
			<tr>
				<td>����:</td>
				<td>
					<input type="text" name="title" size="10" value="��RE:${freeboardarticle.title}">
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
</body>
</html>
