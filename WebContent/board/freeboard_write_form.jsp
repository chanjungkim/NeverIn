<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>글 작성 화면</title>
</head>
<body>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
<div class="container">    
	<form action="${myContextPath}/freeboard" method="post">
		<input type="hidden" name="type" value="write">	
		<input type="hidden" name="id" value="${sessionScope.loginId}">											
		<table class="table table-bordered">
			<tr>
				<td>제목:</td>
				<td>
					<input type="text" name="title" size="10">
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
	</div>
</body>
</html>