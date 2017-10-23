<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="menu.jsp">NEVER 지식IN</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">Home</a></li>
				<li><a class="dropdown" href="neverIn/board_list.jsp">지식Q&A</a>
					<ul class="dropdown-menu">
						<li><a href="board/page2.jsp">교육</a></li>
						<li><a href="board/page3.jsp">컴퓨터</a></li>
						<li><a href="board/page4.jsp">엔터테인먼트</a></li>
					</ul></li>
				<li><a href="board/page5.jsp">자유 게시판</a></li>
				<li><a href="board/page6.jsp">설정</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>