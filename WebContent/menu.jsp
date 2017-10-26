<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html lang="en">
<head>
<title>NEVER 지식IN-무엇이든 물어보세요</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
ul.nav li.dropdown:hover>ul.dropdown-menu {
	display: block;
	margin: 0;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<c:set var="myContextPath" 
			value="${pageContext.request.contextPath}"/>
	
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a class="dropdown" href="${myContextPath}/board">지식Q&A</a>
<!-- 					<ul class="dropdown-menu"> -->
<!-- 						<li><a href="qa/page2.jsp">교육</a></li> -->
<!-- 						<li><a href="qa/page3.jsp">컴퓨터</a></li> -->
<!-- 						<li><a href="qa/page4.jsp">엔터테인먼트</a></li> -->
<!-- 					</ul></li> -->
				<li><a href="${myContextPath}/freeboard">자유 게시판</a></li>
				<li><a href="board/page6.jsp">설정</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>