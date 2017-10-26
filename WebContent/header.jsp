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
	left: 0px;
	margin-top: 5px;
	margin-bottom: 5px;
}
.member-info-container{
	right: 0px;
}
#member-info-table{
	margin: 5px;
	margin-right: 100px;
	border-style: groove;
}

</style>
</head>
<body>
<div class="container" style="width:100%; background-color:#ebea00 ">
	<span class="logo-container">
		<img id="logo" src="img/logo.png">
	</span>
	<div class="member-info-container" style="float: right">
		<table id="member-info-table">
			<tr>
				<td colspan="2">
					<h4>로그인 정보</h4>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<b>${sessionScope.memberInfo.nickname}</b>
					(${sessionScope.memberInfo.id})
				</td>
			</tr>
			<tr>
				<td>
					<b>레벨</b>
				</td>
				<td>
					${sessionScope.memberInfo.lv}
				</td>
			</tr>
			<tr>
				<td>
					<b>포인트</b>
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