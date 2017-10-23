<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
form{
	position:absolute;
	top: 25%;
}
button{
	margin-top: 10px;
	width: 100%;
	background-color: blue;
	color: blue;
}
.main-panel{
  position:absolute;
  top:0;right:0;bottom:0;left:0;
  display:flex;
  align-items:center;
  justify-content:center;

  display:-webkit-flex;
  -webkit-align-item;center;
  -webkit-justify-content:center;
}
.logo{
	position:absolute;
	width:100px;
	height:100px;
}
.login-panel {
	display: inline-block;
	width: 300px;
	height: 500px;
	background-color: #FFF;
	margin: -2.5px;
	border-radius: 50px;
	border-color: black;
	border-width: 5px;
	padding: 5px 15px;
}
.panel-body{
	margin: 20px;
}
</style>
</head>
<body>
	<nav></nav>
	<div class="main-panel">
		<div class="panel panel-default login-panel">
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="form-group">
						<table>
							<tr>
								<td><label>아이디</label></td>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" class="form-control" id="id"	placeholder="아이디를 입력하세요.">
								</td>
							</tr>
							<tr>
								<td><label>비밀번호</label></td>
								<td></td>							
							</tr>
							<tr>
								<td colspan="2"><input type="password" class="form-control" id="pwd"
								placeholder="비밀번호를 입력하세요.">
								</td>
							</tr>
							<tr>
								<td><label><input type="checkbox">기억하기</label>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<button type="submit" class="btn btn-default"">로그인</button>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<a href="#">
								<button type="submit" class="btn btn-default">회원가입</button>
									</a>
								</td>
							</tr>
						</table>						
					</div>
				</form>
			</div>
		</div>
		<div class="logo">
			<a href="http://naver.com">
				<img src="./images/logo.png" class="logo img-circle">
			</a>
		</div>
		<div class="panel panel-default login-panel">
			<div class="panel-body">
				<form class="form-horizontal">
					<table>
						<tr>
							<td><label>닉네임</label></td>
							<td></td>
						</tr>
						<tr>
							<td>
								<input type="text" class="form-control" id="nick" placeholder="닉네임을 입력하세요.">
							</td>
						</tr>
						<tr>
							<td>
								<button type="submit" class="btn btn-default">들어가기</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>