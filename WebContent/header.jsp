<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
div{
	display:inline-block;
}
img{
height:100px;
width:200px
}
#logo{
	left:0px;
}
.member-info-container{
	right: 0px;
}

</style>
</head>
<body>
<div class="container">
	<span class="logo-container">
		<img id="logo" src="img/logo.png">
	</span>
	<div class="member-info-container">
		<table border="1">
			<tr>
				<th colspan="2">
					로그인정보
				</th>
			</tr>
			<tr>
				<td colspan="2">
					${sessionScope.memberInfo.nickname}
					<b>${sessionScope.memberInfo.id}</b>
				</td>
			</tr>
			<tr>
				<td>
					레벨
				</td>
				<td>
					${sessionScope.memberInfo.lv}
				</td>
			</tr>
			<tr>
				<td>
					포인트
				</td>
				<td>
					${sessionScope.memberInfo.point}
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>