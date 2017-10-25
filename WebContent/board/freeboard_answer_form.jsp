<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>답글 작성 화면</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>    
	<form action="${myContextPath}/freeboard" method="post">
		<input type="hidden" name="type" value="answer">	
		아이디<input type="text" name="id" value="${sessionScope.loginId}"><br>
		상위글번호<input type="text" name="articleNum" value="${freeboardarticle.articleNum}"><br>
		<table border="1">
			<tr>
				<td>제목:</td>
				<td>
					<input type="text" name="title" size="10" value="└RE:${freeboardarticle.title}">
				</td>
			</tr>
			<tr>
				<td>내용:</td>
				<td>
					<textarea rows="5" cols="10" name="contents" placeholder="여기에 내용을 입력하세요."></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성완료">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
